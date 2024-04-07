package javatests;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// check fail fast behaviour of HashMap which doesn't allow modification
// while being iterated.

public class FailFastTest {
    public static void main(String[] args) {
        FailFastFromThread failTest = new FailFastFromThread();
        failTest.runThreads();
//
//		Map<String, String> phone = new HashMap<String, String>();
//		phone.put("Apple", "iPhone");
//		phone.put("HTC", "HTC one");
//		phone.put("Samsung", "S5");
//
//		Iterator it = phone.keySet().iterator();
//
//		while(it.hasNext()) {
//			System.out.println(phone.get(it.next()));
//			phone.put("Sony", "Xperia Z");
//		}
    }

}

class FailFastFromThread {

    private volatile List<Integer> integers = new LinkedList<>();

    void runThreads() {

        Integer i = 0;

        Runnable r1 = () -> {
            while (true) {
                System.out.println("accessing thread " + Thread.currentThread());
                integers.forEach(num -> {
                    System.out.println(num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        };

        Runnable r2 = () -> {
            while (true) {
                System.out.println("modifying thread " + Thread.currentThread());
                integers.add(integers.size() + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(r1);
        service.submit(r2);

    }
}