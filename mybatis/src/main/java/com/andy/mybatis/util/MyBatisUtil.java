package com.andy.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	public static MyBatisUtil getUtil() {
		return util;
	}

	private static MyBatisUtil util = new MyBatisUtil();

	private SqlSessionFactory factory = null;

	private MyBatisUtil() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public SqlSession getSession() {
		return factory.openSession();
	}
}
