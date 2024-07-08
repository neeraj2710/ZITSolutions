package in.co.zitsolutions.task2_multithreading.name_and_priority;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hi" + Thread.currentThread().getPriority());
                try{Thread.sleep(1000);}catch(InterruptedException ignored){}
            }
        },"Thread-Hi");
        Thread t2 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello" + Thread.currentThread().getPriority());
                try{Thread.sleep(1000);}catch(InterruptedException ignored){}
            }
        },"Thread-Hello");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

//        t1.setName("Thread-Hi");
//        t2.setName("Thread-Hello");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.start();
        try{Thread.sleep(10);}catch(InterruptedException ignored){}
        t2.start();

//        System.out.println(t2.isAlive());

//        use to pause main thread till t1 and t2 get terminated
        t1.join();
        t2.join();

//        use to check whether a thread is alive or not
//        System.out.println(t1.isAlive());

        System.out.println("Bye");
    }
}
