package in.co.task2_multithreading.using_runable_interface;

public class Hi implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try{Thread.sleep(1000);}catch(InterruptedException ignored){}
        }
    }
}
