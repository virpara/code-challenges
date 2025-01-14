package book.effectivejava;

import java.util.LinkedList;
import java.util.List;

// using Object.wait and notify
//abstract class WorkQueue {
//    private final List<Object> queue = new LinkedList();
//    private boolean stopped = false;
//
//    protected WorkQueue() {
//        new WorkerThread().start();
//    }
//
//    public final void enqueue(Object workItem) {
//        synchronized (queue) {
//            queue.add(workItem);
//            queue.notify();
//        }
//    }
//
//    public final void stop() {
//        synchronized (queue) {
//            stopped = true;
//            queue.notify();
//        }
//    }
//
//    protected abstract void processItem(Object workItem) throws InterruptedException;
//
//    // Broken - invokes alien method from synchronized block!
//    private class WorkerThread extends Thread {
//        public void run() {
//            while (true) { // Main loop
//                synchronized (queue) {
//                    try {
//                        while (queue.isEmpty() && !stopped)
//                            queue.wait();
//                    } catch (InterruptedException e) {
//                        return;
//                    }
//
//                    if (stopped) return;
//
//                    Object workItem = queue.remove(0);
//                    try {
//                        processItem(workItem); // Lock held!
//                    } catch (InterruptedException e) {
//                        return;
//                    }
//
//                }
//            }
//        }
//    }
//}

// HORRIBLE PROGRAM - uses busy-wait instead of Object.wait!
abstract class WorkQueue {
    private final List queue = new LinkedList();
    private boolean stopped = false;

    protected WorkQueue() {
        new WorkerThread().start();
    }

    public final void enqueue(Object workItem) {
        synchronized (queue) {
            queue.add(workItem);
        }
    }

    public final void stop() {
        synchronized (queue) {
            stopped = true;
        }
    }

    protected abstract void processItem(Object workItem) throws InterruptedException;

    private class WorkerThread extends Thread {
        public void run() {
            final Object QUEUE_IS_EMPTY = new Object();
            while (true) { // Main loop
                Object workItem = QUEUE_IS_EMPTY;
                synchronized (queue) {
                    if (stopped)
                        return;
                    if (!queue.isEmpty())
                        workItem = queue.remove(0);
                }
                if (workItem != QUEUE_IS_EMPTY) {
                    try {
                        processItem(workItem);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }
}

class PingPongQueue extends WorkQueue {
    volatile int count = 0;

    protected void processItem(final Object sender) {
        count++;
        WorkQueue recipient = (WorkQueue) sender;
        recipient.enqueue(this);
    }
}

class WaitQueuePerf {
    public static void main(String[] args) {
        PingPongQueue q1 = new PingPongQueue();
        PingPongQueue q2 = new PingPongQueue();

        q1.enqueue(q2); // Kick-start the system

        // Give the system 10 seconds to warm up
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        // Measure the number of round trips in 10 seconds
        // 347749 times for wait-notify
        // 3943567 times for busy-wait !
        int count = q1.count;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println(q1.count - count);
        q1.stop();
        q2.stop();
    }
}

