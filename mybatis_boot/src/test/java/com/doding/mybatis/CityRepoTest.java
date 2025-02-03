package com.doding.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doding.mybatis.model.dto.City;
import com.doding.mybatis.model.repo.CityRepo;

@SpringBootTest
public class CityRepoTest {
    @Autowired
    CityRepo cRepo;

    @Test
    public void selectTest() {
        City city = cRepo.select(2331);
        assertEquals(city.getName(), "Seoul");
    }

    @Test
    public void selectByCountryTest() {
        List<City> selected = cRepo.selectByCountry("KOR");
        assertEquals(selected.size(), 70);
    }
}
