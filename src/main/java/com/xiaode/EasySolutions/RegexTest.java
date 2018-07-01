package com.xiaode.EasySolutions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thid program tests regular expression matching. Enter a pattern and strings to match,
 * or hit Cancel to exit. If the pattern contains groups, the group boundaries are displayed
 * in the match
 * @Version
 * @author xiaode
 */
public class RegexTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern");
        String patternString = in.nextLine();

        Pattern pattern = Pattern.compile(patternString);

        while(true) {
            System.out.println("Enter String to match:");
            String input = in.nextLine();
            if (input == null || input.equals("")) return;
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()) {
                System.out.println("Match");
                int g = matcher.groupCount();
                if(g > 0){
                    for (int i = 0; i < input.length() ; i++) {
                        ///Print any empty groups

                    }
                }
            }
        }
    }

}
