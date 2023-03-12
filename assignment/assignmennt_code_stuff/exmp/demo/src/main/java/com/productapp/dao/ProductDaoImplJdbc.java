package com.productapp.dao;
import java.util.*;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

public class ProductDaoImplJdbc implements ProductDao {

	@Override
	public List<String> getAll() {
		System.out.println("jdbc impl");
		return List.of("tv","laptop","keyboard");
	}

}
