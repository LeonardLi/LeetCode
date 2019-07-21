package com.xiaode.EasySolutions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liyangde on Jul, 2019
 */
public class Foo {
    AtomicInteger i;

    public Foo() {
        i = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
            while(i.get() == 0) {
                printFirst.run();
                i.incrementAndGet();
            }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
            while (i.get() == 1) {
                printSecond.run();
                i.incrementAndGet();
            }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(i.get()==2) {
            printThird.run();
            i.incrementAndGet();
        }
    }
}

