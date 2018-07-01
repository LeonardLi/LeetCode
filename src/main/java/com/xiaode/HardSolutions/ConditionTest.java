package com.xiaode.HardSolutions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaode on 3/23/17.
 */
public class ConditionTest {
    public static void main(String[] args) {
        LockService lockService = new LockService();
        ThreadA[] A = new ThreadA[10];
        ThreadB[] B = new ThreadB[10];
        for (int i = 0; i < 10; i++) {
            A[i] = new ThreadA(lockService);
            B[i] = new ThreadB(lockService);
            A[i].start();
            B[i].start();
         }
        ThreadA a = new ThreadA(lockService);
        ThreadB b = new ThreadB(lockService);
        a.start();
        b.start();
    }
}

class LockService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try {
            lock.lock();
            while(hasValue == true){
                System.out.println("AAA in P ");
                condition.await();

            }
            System.out.println("AAA");
            hasValue = true;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void get(){
        try {
            lock.lock();
            while(hasValue == false){
                System.out.println("BBB in C");
                condition.await();
            }
            System.out.println("BBBBBBB");
            hasValue = false;
            condition.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        } finally {

        }
    }
}

class ThreadA extends Thread {
    private  LockService lockService;
    public ThreadA(LockService lockService){
        super();
        this.lockService = lockService;
    }

    @Override
    public void run(){
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            System.out.println(this.getName());
            this.lockService.set();
        }

    }
}

class ThreadB extends Thread {
    private  LockService lockService;
    public ThreadB(LockService lockService){
       // super();
        this.lockService = lockService;
    }

    @Override
    public void run(){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(this.getName());
            this.lockService.get();
        }
    }
}