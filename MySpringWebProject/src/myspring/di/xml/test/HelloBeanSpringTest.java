package myspring.di.xml.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

//SpringJunit4ClassRunner는 TestCase를 실행해주면서
//Spring컨테이너 역할을 하는 ApplicationContext 객체를 생성해준다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	
	//factory.getBean("hello")와 같음
	@Autowired
	//hello 타입이 2개이상일 때 자동으로 변수명과 동일한 bean을 가져옴. 무시하고 싶을 때 사용
	@Qualifier("helloC") 
	Hello hello;
	
	@Autowired
	@Qualifier("conPrinter")
	Printer printer;
	
//	Printer printer; printer라는 id를 가진애가 2명이라서 에러발생
	
	@Test
	public void helloBean() {
		System.out.println(hello.sayHello());
		hello.print();
		
		List<String> names = hello.getNames();
		for(int i =0; i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
		for (String name : names) {
			System.out.println(name);
		}
	}
}
