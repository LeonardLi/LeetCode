package com.xiaode;

import com.xiaode.EasySolutions.*;
import com.xiaode.HardSolutions.MedianOfTwoSortedArrays;
import com.xiaode.MediumSolutions.CountingBits;
import com.xiaode.MediumSolutions.ContainerWithMostWater;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Main {
    public static int MAX_VALUE = 2000;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        //boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;
        Box box = new Box();
        Model[] items;
        while (scanner.hasNext()) {
            box.length = scanner.nextInt();
            box.width = scanner.nextInt();
            box.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            List<Model> list = Arrays.asList(items);
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println(process(list, box));

        }
    }

    private static int process(List<Model> items, Box box) {
        int number = -1;
        int [][] dp = new int[items.size()][];
        for (int i  = 0 ; i < items.size();i++){
            for(int j = 0 ; j < MAX_VALUE;j++) {
                if(i==0||j==0)
                {
                    dp[i][j]=0;

                }else {
                    if (j<items.get(i).getPrice()) {
                        dp[i][j]=dp[i-1][j];
                    }else {
                        int value=items.get(i).getPrice();
                        //int weight=items.;
                        //dp[i][j]=Math.max(dp[i-1][j-weight]+value,dp[i-1][j]);
                    }
                }
            }
        }
        return number;

    }
}

class Box {
    int length;
    int width;
    int height;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
class Model{
        int price;
        int length;
        int height;
        int width;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }


