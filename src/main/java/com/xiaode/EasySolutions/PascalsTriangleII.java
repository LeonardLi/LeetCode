package com.xiaode.EasySolutions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liyangde on Sep, 2018
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0 ) return Arrays.asList(1);
        List<Integer> row = new ArrayList<>();
        long nCK = 1;
        // Binomial theorem
        for (int i = 0; i <= rowIndex; i++) {
            //row.add(factorial(rowIndex).divide(factorial(i).multiply(factorial(rowIndex - i))).intValueExact());//不需要通项，只需要递推项即可
            row.add((int) nCK);
            nCK = nCK * (rowIndex - i) / (i + 1);
        }

        return row;
    }

    private BigDecimal factorial(int n) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal a;
        for(int i = 2; i <= n; i++){
            a = new BigDecimal(i);//将i转换为BigDecimal类型
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>
        }
        return result;
    }
}
