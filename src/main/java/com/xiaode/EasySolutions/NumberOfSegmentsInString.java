package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 */
public class NumberOfSegmentsInString {
    //wrong
    public int countSegments(String s) {
        if (s.equals("")) return 0;
        String[] segments = s.split(" ");
        return segments.length;
    }

    public int countSegments2(String s) {
        if(s.trim().length()==0) return 0;
        String[] str = s.split("\\s+");
        return str.length;
    }
}
