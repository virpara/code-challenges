package javatests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// check fail fast behaviour of HashMap which doesn't allow modification
// while being iterated.

public class FailFastTest {
	public static void main(String[] args) {
		Map<String, String> phone = new HashMap<String, String>();
		phone.put("Apple", "iPhone");
		phone.put("HTC", "HTC one");
		phone.put("Samsung", "S5");

		Iterator it = phone.keySet().iterator();

		while(it.hasNext()) {
			System.out.println(phone.get(it.next()));
			phone.put("Sony", "Xperia Z");
		}
	}

}