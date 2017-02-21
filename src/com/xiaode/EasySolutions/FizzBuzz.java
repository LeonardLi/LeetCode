package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaode on 2/21/17.
 */
public class FizzBuzz {
    /**
     * 412. Fizz Buzz
     * Write a program that outputs the string representation of numbers from 1 to n.
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output
     * “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     */

    public List<String> fizzBuzz(int n){
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            if (i % 3 == 0){
                if(i % 5 == 0){
                    result.add(fizzBuzz);
                    continue;
                } else {
                    result.add(fizz);
                    continue;
                }
            }
            if (i % 5 == 0){
                result.add(buzz);
                continue;
            }else{
                result.add(String.valueOf(i));
                continue;
            }

        }
        return result;

    }
}
