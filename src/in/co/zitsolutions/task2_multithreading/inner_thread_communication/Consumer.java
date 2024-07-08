package in.co.zitsolutions.task2_multithreading.inner_thread_communication;

public class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this,"Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.getNum();
            try {Thread.sleep(1000);} catch (InterruptedException ignored) {}
        }
    }
}
