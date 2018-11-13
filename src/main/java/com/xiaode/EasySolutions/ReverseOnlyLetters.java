package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Nov, 2018
 *
 * 917. Reverse Only Letters
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Note:
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int p1 = S.length()-1;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 >= 0) {
            if (Character.isLetter(S.charAt(p1))){
                if (!Character.isLetter(S.charAt(p2))){
                    sb.append(S.charAt(p2));
                    p2++;
                }else {
                    sb.append(S.charAt(p1));
                    p1--;
                    p2++;
                }
            } else {
                p1--;
            }
        }
        if(p2 < S.length()) sb.append(S.substring(p2));
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
