package myspring.di.xml;

public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();
	
	public StringPrinter() {
		System.out.println("Stringprinter Contstructor »£√‚µ ");
	}

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
