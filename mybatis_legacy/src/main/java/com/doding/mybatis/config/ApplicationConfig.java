package com.doding.mybatis.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.doding.mybatis.model.repo.CountryRepo;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@PropertySource("classpath:/db/dbinfo.properties")
@ComponentScan("com.doding")
@EnableTransactionManagement
@MapperScan(basePackageClasses = {CountryRepo.class})
@Slf4j
public class ApplicationConfig {
	@Value("${datasource.driver-class-name}")
	private String driver;
	
	@Bean
	public DataSource ds(@Value("${datasource.driver-class-name}") String driver,
			@Value("${datasource.url}") String url, @Value("${datasource.password}") String pass,
			@Value("${datasource.username}") String username) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driver);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(pass);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		factoryBean.setTypeAliasesPackage("com.doding.mybatis.model.dto");
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:/db/mapper/*.xml"));
		return factoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sfb) throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sfb.getObject());
		return template;
	}
}
