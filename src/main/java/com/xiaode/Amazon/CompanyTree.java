package com.xiaode.Amazon;

import java.util.ArrayList;

/**
 * Created by liyangde on Jan, 2019
 */
public class CompanyTree {

    //两个全局变量用来找最小的平均值,和对应的节点
    private double resAve = Double.MIN_VALUE;
    private Node result;

    public Node getHighAve(Node root) {
        if (root == null) return null;
        dfs(root);
        return result;
    }

    //后序遍历递归。
    private SumCount dfs(Node root) {
        if (root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }

        int curSum = root.val;
        int curCnt = 1;
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum / curCnt;
        if (resAve < curAve) {
            resAve = curAve;
            result = root;
        }
        return new SumCount(curSum, curCnt);
    }
}

//这个类是自己写的,要不不好找,两个成员变量分别是当前的总和和人数
class SumCount {
    int sum;
    int count;

    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}