package javatests;

import java.util.*;

public class ArrayClassTest {

	public static void main(String[] args) {
		int[] i = new int[5];
		Object obj = new Object();
		List l = new ArrayList();

		System.out.println(i.getClass().getName()); // array are special objects
		System.out.println(ArrayClassTest.class.getName());
		System.out.println(obj.getClass().getName());
		System.out.println(l.getClass().getName());
	}
}