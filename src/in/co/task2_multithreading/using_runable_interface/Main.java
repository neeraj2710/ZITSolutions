package in.co.task2_multithreading.using_runable_interface;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Hi());
        Thread t2 = new Thread(new Hello());

        t1.start();
        try{Thread.sleep(10);}catch(InterruptedException ignored){}
        t2.start();
    }
}
