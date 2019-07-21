package com.xiaode.EasySolutions;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Created by liyangde on Jul, 2019
 *
 * 1116. Print Zero Even Odd
 */

public class ZeroEvenOdd {
    private int n;
    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);
    private Semaphore sem3 = new Semaphore(0);
    private boolean btn = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n; ++i) {
            sem1.acquire();
            printNumber.accept(0);
            if(btn) sem2.release();
            else sem3.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n;) {
            sem3.acquire();
            printNumber.accept(i);
            i=i+2;
            btn = !btn;
            sem1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n;) {
            sem2.acquire();
            printNumber.accept(i);
            i=i+2;
            btn = !btn;
            sem1.release();
        }
    }
}