package javatests;

public class OverloadingTest {
	public static void main(String[] args) {
		OverloadingTest o = new OverloadingTest();
        o.add(20, 20);
        o.call("Test");
    }

    public void call(String s) {
        System.out.println("string");
    }

    public void call(Object o) {
        System.out.println("object");
    }

    public void add(int a, int b) {
        System.out.println("int int");
	}

	public void add(long a, int b) {
		System.out.println("long int");
	}

	public void add(int a, long b) {
		System.out.println("int long");
	}
}