package com.xiaode.EasySolutions;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaode on 4/6/17.
 */
public class StreamTest {
    public static void main (String[] args){
        //System.out.println(System.getProperty("user.dir"));
        //testStream();
        try {
            testReadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void testReadFile() throws IOException{
        File file = new File("test.xml");
        Path path = file.toPath();
        List<String> lines = Files.readAllLines(path);
        byte[] bytes = Files.readAllBytes(path);
//        for(String s : lines){
//            System.out.println(s);
//        }
        String content = new String(bytes, Charset.defaultCharset());
        System.out.println(content);
//        for (int i = 0; i < bytes.length ; i++) {
//            System.out.println(bytes[i]);
//        }

    }
    public static void testRandomAccessFile() throws FileNotFoundException,IOException{
        File file = new File("678173.bmp");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        raf.skipBytes(54);
        while(true){
            int i = raf.read();
            raf.seek(raf.getFilePointer() - 1);
            raf.write(255 - i);
            if (raf.getFilePointer() >= file.length()) break;
        }
        System.out.println(raf.getFilePointer());

    }

    public static void testStream(){

        try{
            FileInputStream fin = new FileInputStream("MyObject.txt");
            //DataInputStream din = new DataInputStream(fin);

            DataInputStream din2 = new DataInputStream(new BufferedInputStream(fin));
            ObjectInputStream oin = new ObjectInputStream(din2);
            Object a = oin.readObject();
            System.out.println(a.getClass());
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
