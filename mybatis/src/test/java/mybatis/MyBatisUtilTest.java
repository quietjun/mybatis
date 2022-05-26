package mybatis;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.andy.mybatis.util.MyBatisUtil;

public class MyBatisUtilTest {

	@Test
	public void test() {
		MyBatisUtil util = MyBatisUtil.getUtil();
		assertThat(util, is(notNullValue()));

		SqlSession session = util.getSession();
		Connection con = session.getConnection();
		System.out.println(con);
		assertThat(con, is(notNullValue()));
	}
}
