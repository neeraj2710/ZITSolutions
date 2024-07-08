package in.co.zitsolutions.task2_multithreading.synchronization;

public class Counter {
    int count;

//    so that it can be accessed by only one thread at a time
    public synchronized void increment() {
        count++;
    }
}
