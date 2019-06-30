package javatests;

public class OverloadingTest {
	public static void main(String[] args) {
		OverloadingTest o = new OverloadingTest();
		// o.add(20, 20);
	}

	public void add(long a, int b) {
		System.out.println("long int");
	}

	public void add(int a, long b) {
		System.out.println("int long");
	}
}