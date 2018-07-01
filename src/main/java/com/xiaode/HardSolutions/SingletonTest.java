package com.xiaode.HardSolutions;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Created by xiaode on 3/23/17.
 */
public class SingletonTest {
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("MyObject.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fisRef = new FileInputStream(new File("MyObject.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyObject implements Serializable{
    private static final long serialVersionUID = 888L;

    private static class MyObjectHandler{
        private static final MyObject myObject= new MyObject();
    }


    private MyObject(){}

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }

    protected Object readResolve() throws ObjectStreamException{
        return MyObjectHandler.myObject;
    }
}

