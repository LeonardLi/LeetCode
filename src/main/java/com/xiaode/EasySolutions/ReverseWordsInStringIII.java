package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Jul, 2018
 *
 * 557. Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 *
 * whitespace and initial word order.
 */
public class ReverseWordsInStringIII {
    //esay way
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            if (result == "") result = sb.reverse().toString();
            else result = result + " " + sb.reverse().toString();
        }
        return result;
    }

    //fast way
    public String reverseWords2(String input) {

        char [] s = input.toCharArray();
        int start = 0;
        int end = 0;
        while((end = find(s,start)) != -1){
            reverse(s,start,end-1);
            start=end+1;
        }
        reverse(s,start,s.length-1);
        return String.valueOf(s);

    }
    public int find(char [] s,int start){
        for(int i = start ; i<s.length;i++){
            if(s[i]==' ') return i;
        }

        return -1;
    }
    public char[] reverse(char[] s, int start , int end){
        if(start >= end) return s;
        while(start<end){
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++; end--;
        }
        return s;
    }
}
