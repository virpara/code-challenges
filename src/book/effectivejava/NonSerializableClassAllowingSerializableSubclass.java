package book.effectivejava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NonSerializableClassAllowingSerializableSubclass {


}

//Nonserializable stateful class allowing serializable subclass
abstract class AbstractFoo {
    private int x, y; // The state
    private boolean initialized = false;

    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }

    /**
     * This constructor and the following method allow subclass's
     * readObject method to initialize our internal state.
     */
    protected AbstractFoo() {
    }

    protected final void initialize(int x, int y) {
        if (initialized)
            throw new IllegalStateException(
                    "Already initialized");
        this.x = x;
        this.y = y;
        // Do anything else the original constructor did....
        initialized = true;
    }

    /**
     * These methods provide access to internal state so it can
     * be manually serialized by subclass's writeObject method.
     */
    protected final int getX() {
        return x;
    }

    protected final int getY() {
        return y;
    }

    // Must be called by all public instance methods
    private void checkInit() throws IllegalStateException {
        if (!initialized)
            throw new IllegalStateException("Uninitialized");
    }
    // Remainder omitted ...
}

//Serializable subclass of nonserializable stateful class
class FooFoo extends AbstractFoo implements Serializable {
    // Constructor does not use any of the fancy mechanism
    public FooFoo(int x, int y) {
        super(x, y);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // Manually deserialize and initialize superclass state
        int x = s.readInt();
        int y = s.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        // Manually serialize superclass state
        s.writeInt(getX());
        s.writeInt(getY());
    }
}