package com.xiaode.EasySolutions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaode on 3/22/17.
 */
public class LockPractice {
    public static void main(String[] args) {
        LockService lockService = new LockService();
        myThreadA a = new myThreadA(lockService);
        myThreadA b = new myThreadA(lockService);
        myThreadA c = new myThreadA(lockService);
        myThreadA d = new myThreadA(lockService);
        a.start();
        b.start();
        c.start();
        d.start();
    }
}

class myThreadA extends Thread {
    private LockService lockService;
    public myThreadA (LockService lockService) {
        super();
        this.lockService = lockService;
    }

    @Override
    public void run(){
        this.lockService.testMethod();
    }
}

class LockService {
    private Lock lock = new ReentrantLock();

    public void testMethod(){
        lock.lock();
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +" "+(i+1));
        }
        lock.unlock();
    }
}