package myspring.di.annot.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class AnnotatedHelloBeanTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	@Qualifier("helloA")
	Hello hello;

	@Autowired
	@Qualifier("helloA")
	Hello hello2;
	
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	@Test
	public void scope() {
		System.out.println(context.getClass().getName());
		Assert.assertSame(hello, hello2);
	}
	
	@Test @Ignore
	public void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 어노테이션", printer.toString());
	}
}
