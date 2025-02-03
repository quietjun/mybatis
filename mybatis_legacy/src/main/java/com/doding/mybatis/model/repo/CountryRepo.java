package com.doding.mybatis.model.repo;

import com.doding.mybatis.model.dto.Country;

public interface CountryRepo {
	
	public int insert(Country country);
	Country select(String code);
}
