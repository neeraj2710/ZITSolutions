package in.co.task2_multithreading.using_thread_class;

public class Hello extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("hello");
            try{ Thread.sleep(500);}catch(InterruptedException e){}
        }
    }
}
