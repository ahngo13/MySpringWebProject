package myspring.users.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Test
	public void student() {
		
		DeptVO dept = new DeptVO(30);
		StudentVO stu = new StudentVO(2000, "�ܸ���", 32, "1�г�", "�ְ�", dept);
		int cnt = session.insert("studentNS.insertStudent",stu);
		System.out.println("��� �Ǽ� : " + cnt);
		
		List<StudentVO> selectList = session.selectList("studentNS.selectStudentDeptById");
		for (StudentVO studentVO : selectList) {
			System.out.println(selectList);
		}
	}
	
	@Test @Ignore
	public void service() {
		UserVO user = userService.getUser("ham2");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void dao() {
		UserVO read = userDao.read("ham2");
		System.out.println(read);
	}
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("ham2","��","��","���ʵ�");
//		user.setUserId("ham");
//		user.setName("��");
//		user.setGender("��");
//		user.setCity("���ʵ�");
		int cnt= session.insert("userNS.insertUser", user);
		System.out.println("��ϵ� �Ǽ� :" + cnt);
	}
	
	@Test @Ignore
	public void update_list() {
		UserVO user = new UserVO("ham","�ϸ�","��","��ϵ�");
		//update
		int cnt= session.update("userNS.updateUser", user);
		System.out.println("������ �Ǽ� :" + cnt);
		//list
		List<UserVO> list = new ArrayList<>();
		list = session.selectList("userNS.selectUserList");
		for (UserVO uservo: list) {
			System.out.println(uservo);
		}
	}
	
	@Test @Ignore
	public void session() {
		UserVO user = session.selectOne("userNS.selectUserById","gildong");
		System.out.println(user);
	}

	@Test @Ignore
	public void selectAll() {
		List<UserVO> list = new ArrayList<>();
		list = session.selectList("userNS.selectUserList");
		System.out.println(list);
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
