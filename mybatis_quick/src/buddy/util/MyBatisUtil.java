package buddy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static MyBatisUtil util = new MyBatisUtil();
	private static final String CONFIG_FILE = "mybatis-config.xml";
	private MyBatisUtil() {
		setupSessionFactory();
	}
	
	public static MyBatisUtil getUtil() {
		return util;
	}
	
	// factory 초기화 필요
	private SqlSessionFactory factory;
	
	private void setupSessionFactory() {
		try(InputStream input = Resources.getResourceAsStream(CONFIG_FILE)){
			factory = new SqlSessionFactoryBuilder().build(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// sqlSession을 얻을 수 있도록 처리
	public SqlSession getSession() {
		return factory.openSession();
	}
}
