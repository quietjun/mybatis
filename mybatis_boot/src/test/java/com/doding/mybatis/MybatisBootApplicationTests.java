package com.doding.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.doding.mybatis.model.dto.Country;
import com.doding.mybatis.model.repo.CountryRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
class MybatisBootApplicationTests {

	@Autowired
	DataSource ds;
	@Autowired
	SqlSessionTemplate sessionTemplate;

	@Test
	public void datasourceTest() {
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
	    assertEquals(country.getName(), "South Korea");
	}
	
	@Test
	public void selectRangeTest() {
	    Map<String, Object> condition = new HashMap<>();
	    condition.put("from", 50);
	    condition.put("perPage", 5);
	    List<Country> selected = cRepo.selectRange(condition);
	    assertEquals(selected.size(), 5);
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
	    Country country = cRepo.select("KOR");
	    // 조회 결과의 name을 newName으로 변경
	    country.setName("newName");
	    // 업데이트 처리
	    cRepo.update(country);
	    // 다시 한번 조회 후 name 확인
	    Country selected = cRepo.select("KOR");
	    assertEquals(selected.getName(), "newName");
	}
	
	@Test
	@Transactional
	public void deleteTest() {
	    Country country = new Country("ATL", "Atlantis", "Africa");
	    int result = cRepo.insert(country);
	    Assertions.assertEquals(result, 1);
	    result = cRepo.delete(country.getCode());
	    Assertions.assertEquals(result, 1);
	    country = cRepo.select("ATL");
	    Assertions.assertNull(country);
	}
	
	@Test
	public void searchTest() {
	    Map<String, Object> condition = new HashMap<>();
	    condition.put("column", "1=1 or region");
	    condition.put("value", "Southern Europe");
	    List<Country> selected = cRepo.search(condition);
	    assertEquals(selected.size(), 15);
	}
}
