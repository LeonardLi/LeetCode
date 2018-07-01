package com.xiaode.EffectiveJava;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by leonard on 22/03/2017.
 */
public class UseConditionWaitNotifyError {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}

class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try{
            lock.lock();
            System.out.println(System.currentTimeMillis());
            condition.await();

        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("release");
        }
    }

    public void signal(){
        try{
            lock.lock();
            System.out.println(System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}

class ThreadA extends Thread {
    private MyService service;
    public ThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.await();
    }
}