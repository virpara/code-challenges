package book.effectivejava.item2;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonStaticFactory implements Serializable{

    private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();

    private SingletonStaticFactory() {

    }

    public static SingletonStaticFactory getInstance() {
        return INSTANCE;
    }

    // This applies to both the singleton approaches
    // To make a singleton class serializable (Chapter 10), it is not sufficient merely to add
    // implements Serializable to its declaration. To maintain the singleton guarantee, you must
    // also provide a readResolve method (Item 57). Otherwise, each deserialization of a serialized
    // instance will result in the creation of a new instance, leading, in the case of our example, to
    // spurious Elvis sightings. To prevent this, add the following readResolve method to the
    // Elvis class:
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
