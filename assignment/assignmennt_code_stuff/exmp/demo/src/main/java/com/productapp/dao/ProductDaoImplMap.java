package com.productapp.dao;
import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

public class ProductDaoImplMap implements ProductDao {

	@Override
	public List<String> getAll() {
		System.out.println("mongo impl");
		return List.of("tv -map","laptop -map","keyboard -map");
	}

}
