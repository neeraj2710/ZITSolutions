package in.co.zitsolutions.task2_multithreading.inner_thread_communication;

public class Main {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

    }
}
