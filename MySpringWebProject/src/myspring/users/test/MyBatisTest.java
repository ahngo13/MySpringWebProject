package myspring.users.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Test
	public void session() {
		System.out.println(factory.getClass().getName());
	}
	
	@Test @Ignore
	public void ds() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
