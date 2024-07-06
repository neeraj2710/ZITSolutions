package in.co.multithreading.using_thread_class;

public class Hi extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            System.out.println("hi");
            try{ Thread.sleep(500);}catch(InterruptedException e){}
        }
    }
}
