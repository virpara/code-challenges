package javatests;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeTest {
	public static void main(String[] args) {
		Map<String, String> phone = new ConcurrentHashMap<String, String>();
		phone.put("Apple", "iPhone");
		phone.put("HTC", "HTC one");
		phone.put("Samsung", "S5");

		Iterator it = phone.keySet().iterator();
		phone.put("Samsung", "S8");
		while(it.hasNext()) {
			System.out.println(phone.get(it.next()));

			// doesn't throw CCM exception and takes effect in the next iterator
			phone.put("Sony", "Xperia Z");
			phone.remove("Apple");
		}

		it = phone.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(phone.get(it.next()));
		}
	}

}