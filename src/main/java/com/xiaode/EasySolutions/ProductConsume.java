package com.xiaode.EasySolutions;



/**
 * Created by xiaode on 3/21/17.
 */
public class ProductConsume {
    public static void main(String[] args){
        String lock = "";
        P p = new P(lock);
        C c = new C(lock);
        ThreadP pThread = new ThreadP(p);
        ThreadC cThread = new ThreadC(c);
        pThread.start();
        cThread.start();
    }


}
class ValueObject {
    public static String value = "";
}

class P {
    private String lock;
    public P(String lock){
        super();
        this.lock = lock;
    }
    public void setValue(){
        try{
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("P:"+value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C {
    private String lock;
    public C (String lock){
        super();
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("C:"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadP extends Thread {
    private P p;
    public ThreadP (P p){
        super();
        this.p = p;
    }
    @Override
    public void run(){
        while (true) {
            p.setValue();
        }
    }
}

class ThreadC extends Thread {
    private C c;
    public ThreadC( C c) {
        super();
        this.c = c;
    }
    @Override
    public void run(){
        while (true){
            c.getValue();
        }

    }
}