package in.co.zitsolutions.task2_multithreading.using_anonymous_class;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Hi");
                    try{Thread.sleep(1000);}catch(InterruptedException ignored){}
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Hello");
                    try{Thread.sleep(1000);}catch(InterruptedException ignored){}
                }
            }
        });

        t1.start();
        try{Thread.sleep(10);}catch(InterruptedException ignored){}
        t2.start();
    }
}
