package buddy.test;

import org.apache.ibatis.session.SqlSession;

import buddy.util.MyBatisUtil;

public class MyBatisUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBatisUtil util = MyBatisUtil.getUtil();
		System.out.println(util);
		SqlSession session = util.getSession();
		System.out.println(session);
	}
}
