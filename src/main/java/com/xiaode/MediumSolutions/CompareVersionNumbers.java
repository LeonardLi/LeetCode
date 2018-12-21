package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Dec, 2018
 *
 * 165. Compare Version Numbers
 *
 *
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        int min = Math.min(versions1.length, versions2.length);

        for (int i = 0; i < min; i++) {
            if (Integer.valueOf(versions1[i]) > Integer.valueOf(versions2[i])) {
                return 1;
            } else if (Integer.valueOf(versions1[i]) < Integer.valueOf(versions2[i])) {
                return -1;
            }
        }
        if (versions1.length > versions2.length) {
            return 1;
        } else if (versions1.length < versions2.length) {
            return -1;
        } else {
            return 0;
        }

    }


    public static void main(String[] args){
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("1.0","1.1"));

    }
}
