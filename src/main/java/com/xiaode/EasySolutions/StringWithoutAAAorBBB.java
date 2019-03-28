package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jan, 2019
 *
 * 984. String Without AAA or BBB
 */
public class StringWithoutAAAorBBB {

    public String strWithout3a3b(int A, int B) {

        String res = "";
        if (A == B) {
            while (A > 0) {
                res +="ab";
                A--;
            }
        }else if (A > B){
            while (A>0 || B>0) {
                if (A > 0) {
                    res+="a";A--;
                    if (A > 0) {
                        res+="a"; A--;
                    }
                }
                if(B>0) {
                    res+="b"; B--;
                }
            }
        } else {
            while (A>0 || B>0) {
                if (B > 0) {
                    res+="b";B--;
                    if (B > 0) {
                        res+="b"; B--;
                    }
                }
                if(A>0) {
                    res+="a"; B--;
                }
            }
        }
        return res;

    }




    public static void main(String[] args) {
        StringWithoutAAAorBBB s = new StringWithoutAAAorBBB();
        System.out.println(s.strWithout3a3b(2,5));
    }
}
