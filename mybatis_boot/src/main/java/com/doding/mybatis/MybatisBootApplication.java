package com.doding.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doding.mybatis.model.repo.CountryRepo;

@SpringBootApplication
@MapperScan(basePackageClasses = {CountryRepo.class})
public class MybatisBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisBootApplication.class, args);
	}

}
