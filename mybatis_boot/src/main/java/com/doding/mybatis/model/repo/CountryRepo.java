package com.doding.mybatis.model.repo;

import java.util.List;
import java.util.Map;

import com.doding.mybatis.model.dto.Country;

public interface CountryRepo {
	
	public int insert(Country country);
    // PK를 이용한 단일건 조회
    Country select(String code);
    List<Country> selectRange(Map<String, Object> condition);
    int update(Country country);
    int delete(String code);
    
   List<Country> search(Map<String, Object> condition);
}
