package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int[] dic = new int [128];
        boolean isContinous = false;
        int lateCount = 0;
        for (char c : s.toCharArray()) {
            dic[c]++;
            if (dic['A'] > 1) return false;

            if (c == 'L') {
                lateCount++;
                if (isContinous){
                    if (lateCount > 2) return false;
                } else {
                    isContinous = true;
                }
            } else {
                isContinous = false;
                lateCount = 0;
            }
        }
        return true;
    }
}
