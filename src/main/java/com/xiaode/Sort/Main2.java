package com.xiaode.Sort;

/**
 * Created by leonard on 26/04/2017.
 */

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        System.out.println(expr);
        String[] exp = expr.split(" ");
        Stack<String> calcStack = new Stack<>();
        int op1 = 0;
        int op2 = 0;
        int temp = 0;
        for(String atom : exp)
        {
            if(isNum(atom))
                calcStack.push(atom);
            else if(isOperator(atom))
            {
                try{
                switch(atom)
                {
                    case "+":
                        op1 = Integer.parseInt(calcStack.pop().toString());
                        op2 = Integer.parseInt(calcStack.pop().toString());
                        temp = op2+op1;break;
                    case "^":
                        op1 = Integer.parseInt(calcStack.pop().toString());
                        temp = op1+1;
                        break;
                    case "*":
                        op1 = Integer.parseInt(calcStack.pop().toString());
                        op2 = Integer.parseInt(calcStack.pop().toString());
                        temp = op2*op1;break;
                }
                }catch (EmptyStackException e){
                    return -1;
                }catch (StackOverflowError e){
                    return -2;
                }
                calcStack.push(String.valueOf(temp));
            }
        }
        return Integer.parseInt(calcStack.pop());
    }
    static boolean isNum(String a){
        if("0".equals(a)|| "0" == a) return true;
        if("1".equals(a)|| "1" == a) return true;
        if("2".equals(a)|| "2" == a) return true;
        if("3".equals(a)|| "3" == a) return true;
        if("4".equals(a)|| "4" == a) return true;
        if("5".equals(a)|| "5" == a) return true;
        if("6".equals(a)|| "6" == a) return true;
        if("7".equals(a)|| "7" == a) return true;
        if("8".equals(a)|| "8" == a) return true;
        if("9".equals(a)|| "9" == a) return true;
        return false;
    }
    static boolean isOperator(String a){
        if("+".equals(a) || "+" == a) return true;
        if("*".equals(a) || "*" == a) return true;
        if("^".equals(a) || "^" == a) return true;
        return false;
    }
}