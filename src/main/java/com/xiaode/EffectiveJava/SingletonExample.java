package com.xiaode.EffectiveJava;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by leonard on 12/03/2017.
 */
public class SingletonExample {
    // 1.
    public static final SingletonExample singleton = new SingletonExample();


    // 2.
    private SingletonExample(){}
    private static final SingletonExample instance = new SingletonExample();
    public static final SingletonExample getInstance(){
        return instance;
    }

    // 3. 并发存在风险
    private static SingletonExample instance2;
    public static final SingletonExample getInstance2(){


        if(instance2 == null){
            instance2 = new SingletonExample();
            return  instance2;
        }
        return instance2;
    }


    // 4.消除并发风险，但性能差
    private static SingletonExample instance3;
    synchronized public static final SingletonExample getInstance3(){
        if(instance3 == null){
            instance3 = new SingletonExample();
            return  instance3;
        }
        return instance3;
    }

    //最优实现，枚举类
    enum Single{
        INSTANCE;

        private Single(){}

        public Single getInstance(){
            return INSTANCE;
        }

    }


}
