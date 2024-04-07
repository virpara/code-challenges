package javatests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Java8Tests {

    public static void main(String[] args) {
        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();

        String str1 = "My";
        String str2 = new String("My");
        System.out.println("z" + str1.matches(str2));

        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow"));

        int a = 9, b = 2;
        float f;

        f = a / b;  // returns int 4, but becomes 4.0 as f is float
        System.out.println(f);

        f = f / 2;
        System.out.println(f);

        f = a + b / f;
        System.out.println(f);

        try {
            Java8Tests t = (Java8Tests) Java8Tests.class.getClassLoader().loadClass("javatests.Java8Tests").newInstance();
//            t = Java8Tests.class.newInstance();
//            t = (Java8Tests) Class.forName("javatests.Java8Tests").newInstance();
//            t = (Java8Tests) Class.forName("javatests.Java8Tests").getClassLoader().loadClass("javatests.Java8Tests").newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Locale l = new Locale("USA");
        System.out.println("Country: " + l.getCountry());

        List list = new ArrayList();
        System.out.println( "list: " + list);
    }
}

class MyCollection<T> {
    private Set<T> set;
    public Set<T> getCollection() {
        return this.set;
    }

    public void Test(MyCollection<?> col) {
//        Set<?> set = col.getCollection(); // valid
        Set set = col.getCollection(); // valid
//        Set<T> set = col.getCollection(); // invalid
//        Set<E> set = col.getCollection(); // invalid
    }
}