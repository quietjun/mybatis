package com.doding.mybatis.model.repo;

import java.util.List;

import com.doding.mybatis.model.dto.City;

public interface CityRepo {
    City select(Integer id);

    List<City> selectByCountry(String code);
}