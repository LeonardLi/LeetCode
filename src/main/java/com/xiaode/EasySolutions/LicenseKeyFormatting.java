package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 482. License Key Formatting
 *
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String[] groups = S.split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < groups.length; i++) {
            sb.append(groups[i]);
        }
        String temp = sb.toString().toUpperCase();
        String result = groups[0];
        for (int i = 0; i < temp.length(); i += K) {
            if(i + K > temp.length()) result = result + "-" + temp.substring(i);
            result = result+"-"+temp.substring(i,i+K);
        }

        return result;
    }

    public String licenseKeyFormatting2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}
