package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Aug, 2018
 *
 * 728. Self Dividing Numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++ ) {
            if (checkSelfDividing(i)) result.add(i);
        }

        return result;
    }
    private boolean checkSelfDividing(int num) {
        int origin = num;
        while(num > 9) {
            int digit = num % 10;
            if (digit == 0) return false;
            if (origin % digit != 0) return false;
            num = num / 10;
        }
        if (origin % num != 0) return false;

        return true;
    }

    public static void main(String[] args){
        SelfDividingNumbers sdn = new SelfDividingNumbers();
        sdn.selfDividingNumbers(1,22);
    }
}
