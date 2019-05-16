package com.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestDataSource extends TestBase {
	@Test
	public void testDruidDataSource()throws Exception {
		DataSource ds=ctx.getBean("dataSource", DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory bean = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(bean);
	}
}
