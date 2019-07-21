package com.xiaode.EasySolutions;

import java.util.concurrent.Semaphore;

/**
 * Created by liyangde on Jul, 2019
 */
public class H2O {
    Semaphore semaphoreH;
    Semaphore semaphoreO;
    volatile boolean flag = false;
    public H2O() {
        semaphoreH = new Semaphore(2);
        semaphoreO = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        semaphoreO.acquire(2);
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}
