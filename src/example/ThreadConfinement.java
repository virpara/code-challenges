package example;

import java.util.ArrayList;
import java.util.List;

public class ThreadConfinement {

    // reference: https://dzone.com/articles/java-concurrency-thread-confinement

    // 1. Ad-Hoc Thread confinement: It is responsibility of developer to ensure
    //    the use of the object is restricted to a single thread
    // 2. Stack Confinement: Confining a variable to the stack of the thread.
    // 3. Using ThreadLocal: It allows you to associate a per-thread value with
    //    a value-holding object.

    // stack confinement
    private long numberOfPeopleNamedJohn(List<Person> people) {
        List<Person> localPeople = new ArrayList<>(); // variable is accessible in this scope only
        localPeople.addAll(people);

        return localPeople.stream()
                .filter(person -> person.getFirstName().equals("John"))
                .count();
    }

    static class Person {
        public String getFirstName() {
            return "John";
        }
    }

    // using ThreadLocal
    static class ThreadConfinementUsingThreadLocal {
        public static void main(String[] args) {
            ThreadLocal<String> stringHolder = new ThreadLocal<>();
            Runnable runnable1 = () -> {
                stringHolder.set("Thread in runnable1");

                try {
                    Thread.sleep(5000);
                    System.out.println(stringHolder.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Runnable runnable2 = () -> {
                stringHolder.set("Thread in runnable2");

                try {
                    Thread.sleep(2000);
                    stringHolder.set("string in runnable2 changed");
                    Thread.sleep(2000);
                    System.out.println(stringHolder.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Runnable runnable3 = () -> {
                stringHolder.set("Thread in runnable3");

                try {
                    Thread.sleep(5000);
                    System.out.println(stringHolder.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            Thread thread3 = new Thread(runnable3);

            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
