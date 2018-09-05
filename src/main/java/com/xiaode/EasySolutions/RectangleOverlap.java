package com.xiaode.EasySolutions;

/**
 * Created by liyangde on Sep, 2018
 *
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec2[1] >= rec1[3]) return false;
        return true;

    }
}
