package book.effectivejava.item2;

public class SingletonStaticFactory {

    private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();

    private SingletonStaticFactory() {

    }

    public static SingletonStaticFactory getInstance() {
        return INSTANCE;
    }
}
