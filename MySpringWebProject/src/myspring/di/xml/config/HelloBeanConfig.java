package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloBeanConfig {

//	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
//		<!-- setName("스프링") -->
//		<property name="name" value="스프링"/>
//		<!-- setPrinter(new StringPrinter()) -->
//		<property name="printer" ref="strPrinter"/>
//	</bean>
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Java Config");
		hello.setPrinter(stringPrinter());
		return hello;
	}
	
	@Bean
	public Printer stringPrinter() {
		Printer printer = new StringPrinter();
		return printer;
	}
	
	@Bean
	public Printer consolePrinter() {
		Printer printer = new ConsolePrinter();
		return printer;
	}
}
