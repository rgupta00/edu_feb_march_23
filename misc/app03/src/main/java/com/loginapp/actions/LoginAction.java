package com.loginapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.loginapp.dao.User;
import com.loginapp.forms.LoginForm;

import com.loginapp.service.UserService;


public class LoginAction extends org.apache.struts.action.Action {

	private UserService userService =null;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		User user = new User(loginForm.getUserName(), loginForm.getPassword());

		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(getServlet().getServletContext());
		
		userService=(UserService) context.getBean("userService");
		
		if (userService.isValid(user)) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
	}
}