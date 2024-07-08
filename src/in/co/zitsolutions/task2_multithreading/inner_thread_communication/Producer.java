package in.co.zitsolutions.task2_multithreading.inner_thread_communication;

public class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.setNum(i++);
            try {Thread.sleep(1000);} catch (InterruptedException ignored) {}
        }
    }
}
