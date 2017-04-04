package com.xiaode.EasySolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiaode on 3/16/17.
 */
public class WordPattern {
    /**
     * 290. Word Pattern
     * Given a pattern and a string str, find if str follows the same pattern.Here follow means a full match, such that
     * there is a bijection between a letter in pattern and a non-empty word in str.
     */

    public static boolean wordPatrtern(String pattern, String str) {
        Map<Character, String> dic = new HashMap<>();
        Map<String,Character> dic2 = new HashMap<>();
        if (pattern == null || str == null ) return false;
        String [] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        for(int i = 0 ;i < pattern.length();i++){
            if(dic.get(pattern.charAt(i)) == null){
                dic.put(pattern.charAt(i),words[i]);
            }else if(!dic.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }

            if (dic2.get(words[i]) ==  null){
                dic2.put(words[i],pattern.charAt(i));
            }else if (!dic2.get(words[i]).equals(pattern.charAt(i))){
                return false;
            }

        }
        return true;
    }


    //use map containsKey/containsValue API
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
       // System.out.println(wordPatrtern("abba","dog cat cat dog"));
        AtomicTest test = new AtomicTest();
        Thread[] tests = new Thread[1000];
        for(int i = 0; i < 1000; i++){
            tests[i] = new Thread(test);
            tests[i].start();
        }


        //a.interrupt();
    }


}


/////////////////////////////////

class myThread extends Thread{
    private int i = 0;

    @Override
    public void run() {
        while(true){
        try {
            i++;
            System.out.println("in"+i);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Stop");
           break;
        }
        }
    }
}

class DealThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run(){
     if(username.equals('a')) {
         synchronized (lock1) {
             try {
                 System.out.println("username:"+ username);
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             synchronized (lock2) {
                 System.out.println("lock1 -> lock2");
             }
         }
     }
     if(username.equals("b")) {
         synchronized (lock2) {
             try{
                 System.out.println("username:"+ username);
                 Thread.sleep(3000);
             }catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (lock1){
                 System.out.println("lock2 -> lock1");
             }
         }
     }
    }
}

class AtomicTest extends Thread{
    private  AtomicInteger ii = new AtomicInteger(0);
      //private   int  iii = 0;
    @Override
    public void run(){
        super.run();
        for (int i = 0 ; i < 100; i++){
            System.out.println(ii.incrementAndGet());
            //System.out.println(iii++);
        }
    }
}