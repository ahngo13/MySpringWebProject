package myspring.di.xml;

public class ConsolePrinter implements Printer {
	
	public ConsolePrinter() {
		System.out.println("ConsolePrinter Constructor »£√‚µ ");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}
