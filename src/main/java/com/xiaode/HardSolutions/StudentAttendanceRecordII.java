package com.xiaode.HardSolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 552. Student Attendance Record II
 *
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 */

//TODO: DP
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        char[] dic = {'A','L','P'};
        String test = "";
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; i++) {
                test +=dic[i];
            }
        }
        return 0;
        
    }

    private boolean checkIfAwarded(String s) {
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
