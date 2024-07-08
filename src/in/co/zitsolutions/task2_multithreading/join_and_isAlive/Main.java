package in.co.zitsolutions.task2_multithreading.join_and_isAlive;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hi");
                try{Thread.sleep(1000);}catch(InterruptedException ignored){}
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello");
                try{Thread.sleep(1000);}catch(InterruptedException ignored){}
            }
        });

        t1.start();
        try{Thread.sleep(10);}catch(InterruptedException ignored){}
        t2.start();

        System.out.println(t2.isAlive());

//        use to pause main thread till t1 and t2 get terminated
        t1.join();
        t2.join();

//        use to check whether a thread is alive or not
        System.out.println(t1.isAlive());

        System.out.println("Bye");
    }
}
