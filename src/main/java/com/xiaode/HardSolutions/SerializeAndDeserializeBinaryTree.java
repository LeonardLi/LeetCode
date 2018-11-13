package com.xiaode.HardSolutions;

import com.xiaode.BinaryTree.TreeNode;

/**
 * Created by liyangde on Nov, 2018
 *
 * 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
    public class Codec{
        public int index = 0;
        public String[] DLRseq;
        public String serialize(TreeNode root){
            StringBuilder s = new StringBuilder();
            if(root == null){
                s.append("null,");
                return s.toString();
            }
            s.append(root.val+",");
            s.append(serialize(root.left));
            s.append(serialize(root.right));
            return s.toString();
        }

        public TreeNode deserialize(String str){
            index++;
            if (DLRseq == null) DLRseq = str.split(",");
            if (index > DLRseq.length) return null;

            TreeNode leave = null;
            if(!DLRseq[index++].equals("null")){
                leave = new TreeNode(Integer.valueOf(DLRseq[index-1]));
                leave.left = deserialize(str);
                leave.right = deserialize(str);
            }
            return leave;
        }
    }
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        Codec codec = serializeAndDeserializeBinaryTree.new Codec();
        codec.deserialize("1,2,3,null,null,4,5");

    }
}
