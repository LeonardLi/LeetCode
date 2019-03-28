package com.xiaode.EasySolutions;

import java.util.*;

/**
 * Created by liyangde on Feb, 2019
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Stack<int[]> position = new Stack<>();
        Stack<int[]> next = new Stack<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) count++;

                if (grid[i][j] == 2) position.push(new int[]{i,j});
            }
        }
        if (count == 0) return 0;
        int min = 0;
        while(position.size() != 0) {
            min++;
            while(position.size() != 0){
                int[] p = position.pop();

                for(int[] dir : dirs) {
                    int res = helper(grid, p[0]+dir[0], p[1]+dir[1]);
                    if(res == 1) next.push(new int[]{p[0]+dir[0], p[1]+dir[1]});
                    count-=res;
                    if (count == 0) return min;
                }
            }
            position = next;
            next = new Stack<>();

            System.out.println("min:"+min+"count:"+count);
        }
        if(count > 0) return -1;

        return min-1;
    }

    private int helper(int[][] grid, int x, int y){
        if(x<0 || x > grid.length-1 || y < 0 || y > grid[x].length-1 || grid[x][y] == 2 || grid[x][y] == 0) return 0;
        grid[x][y] = 2;
        return 1;
    }

    public static void main(String[] args){
        RottingOranges r= new RottingOranges();
        System.out.println(r.orangesRotting(new int[][]{{1},{2},{1},{2}}));

    }



    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        String first = A[0];
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (char c : first.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i =1; i < A.length; i++) {
            String tempStr = A[i];
            for (char c : tempStr.toCharArray()) {
                temp.put(c, temp.getOrDefault(c,0)+1);
            }
            for(Character c : map.keySet()) {
                if (!temp.containsKey(c)) map.remove(c);
                if(temp.containsKey(c) && map.get(c) > temp.get(c)) {
                    map.put(c, temp.get(c));
                }
            }

        }

        for(Character c : map.keySet()) {
            int num = map.get(c);
            while(--num>0) res.add(String.valueOf(c));
        }


        return res;
    }

    public boolean isValid(String S) {
//        if (S.length() < 6 && !S.equals("abc")) return false;
//        if (S.equals("abc")) return true;
        Stack<Character> store = new Stack<>();

        for(char c : S.toCharArray()) {
            if (c == 'c') {
                if(store.size() < 2) return false;
                System.out.println(c);
                char p1 = store.pop();
                char p2 = store.pop();
                if (p1 != 'b' || p2 != 'a') {
                    store.push(p2);
                    store.push(p1);
                }

            } else {
                store.push(c);
            }
        }

        return store.size() == 0;
//        String[] strs = S.split("abc");
        //String next = S.replace("abc", "");
//        if(strs.length <2) return false;
//        String next = "";
//        for(String str : strs) {
//            next+=str;
//        }
        //return isValid(next);
    }
}
