package com.doding.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.doding.mybatis.config.ApplicationConfig;
import com.doding.mybatis.model.dto.Country;
import com.doding.mybatis.model.repo.CountryRepo;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Transactional
@Slf4j
public class MyBatisConfigTest {

	@Autowired
	DataSource ds;

	@Autowired
	SqlSessionTemplate sessionTemplate;

	@Test
	public void baseBeanTest() {
		Assertions.assertNotNull(ds);
		Assertions.assertNotNull(sessionTemplate);
		Assertions.assertEquals(ds.getClass().getSimpleName(), "HikariDataSource");
		Assertions.assertNotNull(sessionTemplate.getConnection());
	}

	@Autowired
	CountryRepo cRepo;

	@Test
	public void insertTest() {
		Country country = new Country("ATL", "Atlantis", "Africa");
		int result = cRepo.insert(country);
		Assertions.assertEquals(result, 1);
	}
	@Test
	public void selectTest() {
	    Country country = cRepo.select("KOR");
	    log.trace("조회결과:{}", country);
	    assertEquals(country.getName(), "South Korea");
	}
}
