package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaode on 3/22/17.
 */
public class myStack {
    private List<String> list = new ArrayList<String>();
    synchronized public void push(){
        try{
            while(list.size() == 1) {
                this.wait();
            }
            list.add("anyString="+Math.random());
            this.notify();
            System.out.println("push"+list.size());

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            while (list.size() == 0){
                System.out.println(Thread.currentThread().getName()+"wait");
                this.wait();
            }

            returnValue = ""+ list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop"+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  returnValue;
    }
}
