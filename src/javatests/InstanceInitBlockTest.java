package javatests;

public class InstanceInitBlockTest {
	static int[] array = new int[4];

	// static block runs only once when the class is loaded
	static { 
		array[3] = 9;
		System.out.println(array[3]);
	}

	// instance init code. it allows to write code which is common to constructors, so it removes duplication
	{
		System.out.println("first instace init block");
	}

	public InstanceInitBlockTest() {
		System.out.println("no-arg constructor called");
	}

	{
		System.out.println("sencond instance init block");
	}

	public InstanceInitBlockTest(int a) {
		System.out.println("one arg constructor called");
	}

	public static void main(String[] args) {
		new InstanceInitBlockTest();
		new InstanceInitBlockTest(1);
	}
}