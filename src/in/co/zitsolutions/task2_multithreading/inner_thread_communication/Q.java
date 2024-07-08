package in.co.zitsolutions.task2_multithreading.inner_thread_communication;

public class Q {
    int num;
    boolean valueSet = false;

    public synchronized void getNum() {
        while (!valueSet) {
            try{wait();} catch (InterruptedException ignored){}
        }
        System.out.println("Get : "+num);
        valueSet = false;
        notify();
    }

    public synchronized void setNum(int num) {
        while (valueSet) {
            try{wait();} catch (InterruptedException ignored){}
        }
        this.num = num;
        System.out.println("num : "+num);
        valueSet = true;
        notify();
    }
}
