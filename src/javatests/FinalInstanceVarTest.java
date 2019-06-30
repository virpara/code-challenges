package javatests;

public class FinalInstanceVarTest {

	// This doesn't work if we assign value from constructor, because static variable
	// is initialized when class is loaded.
	// static final Object o;

	final Object o;

	public FinalInstanceVarTest() {
		// required to initialize final instance variable in constructor
		o = new Object();
	}

	public void print() {
		// cannot assign value to final var
//		o = new Object();
		System.out.println(o);
	}

	public static void main(String[] args) {
		new FinalInstanceVarTest().print();
	}
}