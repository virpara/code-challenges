package book.effectivejava.item2;

public class SingletonFinalField {

    public static final SingletonFinalField INSTANCE = new SingletonFinalField();

    // private constructor to prevent instantiation by other classes
    // it is called only once to initialize INSTANCE field
    private SingletonFinalField() {

    }


}
