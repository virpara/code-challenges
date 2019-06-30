package javatests;//import java.util.Comparable;

public class PrivateTest {

	public static void main(String[] args) {
		User u1 = new User("a", "b");
		User u2 = new User("x", "y");
		u1.compareTo(u2);
	}
}

class User implements Comparable {

	private String firstName;
	private String lastName;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int compareTo(Object p) {
		if (p instanceof User) {
			User u = (User) p; 
			System.out.println(u.firstName + " " + u.lastName);
		}
		return 0;
	}
}