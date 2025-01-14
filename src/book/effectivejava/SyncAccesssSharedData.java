package book.effectivejava;

class SyncAccessSharedData {
    // required synchronization
    private static int nextSerial = 0;

    public static int generateNext() {
        return nextSerial++;
    }

}

// requires synchronization
//class StoppableThread extends Thread {
//	private boolean stopRequested = false;
//
//	public void run() {
//		boolean done = false;
//
//		while (!stopRequested && !done) {
//			// do something interesting here
//		}
//	}
//
//	public void requestStop() {
//		stopRequested = true;
//	}
//}

// properly synchronized cooperative thread termination
class StoppableThreadSynchronized extends Thread {
    private boolean stopRequested = false;

    public void run() {
        boolean done = false;

        while (!stopRequested() && !done) {
            // do something interesting here
        }
    }

    public synchronized void requestStop() {
        stopRequested = true;
    }

    public synchronized boolean stopRequested() {
        return stopRequested;
    }
}

class Foo {
}

// double check idiom for lazy initialization - broken
class LazyInitBroken {
    private static Foo foo = null;

    public static Foo getFoo() {
        if (foo == null) {
            synchronized (Foo.class) {
                if (foo == null)
                    foo = new Foo();
            }
        }
        return foo;
    }
}

// easy way to fix it is to dispense with lazy initialization entirely
class NormalStaticInit {
    private static final Foo foo = new Foo();

    public static Foo getFoo() {
        return foo;
    }
}

// properly synchronized lazy init, but incurs cost of synchronization
class ProperLazyInit {
    private static Foo foo = null;

    public static synchronized Foo getFoo() {
        if (foo == null) foo = new Foo();
        return foo;
    }
}

// init-on-demand holder class idiom
class InitOnDemandHolder {
    public static Foo getFoo() {
        return FooHolder.foo;
    }

    private static class FooHolder {
        static final Foo foo = new Foo();
    }
}

