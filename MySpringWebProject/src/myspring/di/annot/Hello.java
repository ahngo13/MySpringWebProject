package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="helloA" class="xxx.Hello">
@Component("helloA")
@Scope(value="singleton")
public class Hello {
	//<property name="name" value="어노테이션"/>
//	@Value("어노테이션")	
	String name;
	
	//<property name="printer" ref="stringPrinter"/>
//	@Autowired
//	@Qualifier("stringPrinter")
	Printer printer;
	
	List<String> names;

	public Hello() {
		System.out.println("Hello Default Constructor 호출됨" + this.getClass().getName());
	}

	@Autowired
	public Hello(@Value("어노테이션") String name, @Qualifier("stringPrinter") Printer printer) {
		System.out.println("Hello Overloading 된 Costructor 호출됨");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
