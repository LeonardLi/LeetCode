package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Aug, 2018
 *
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 *
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 *
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find
 *
 * the first bad version. You should minimize the number of calls to the API.
 */



public class FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int start = 1;
        int end = n;
        int mid = 0;
        while(end > start) {
            mid = (end + start) >>> 1;
            if (!isBadVersion(mid)) {
                //not bad
                if (isBadVersion(mid + 1)) return mid + 1;
                else {
                    start = mid;
                }
            } else {
                //bad
                if (!isBadVersion(mid - 1)) return mid;
                else {
                    end = mid;
                }
            }
        }
        return mid;
    }

    private boolean isBadVersion(int num) {
        return true;
    }
}
