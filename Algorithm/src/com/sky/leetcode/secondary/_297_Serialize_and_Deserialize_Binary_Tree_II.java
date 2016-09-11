package com.sky.leetcode.secondary;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SkyDream on 2016/9/8.
 */
public class _297_Serialize_and_Deserialize_Binary_Tree_II {

    public static void main(String args[]) {
        String s = "china";
        char c[] = {'c','h','i','n','a'};
        System.out.println(s==c.toString());
    }
}

    private final static String NULL = "#";
    private final static String SEPARATER = ",";

    public String serialize(TreeNode root){
        if(root == null) return NULL + SEPARATER;
        return "" + root.val + SEPARATER + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data){
        return deserialize(new StringBuilder(data));
    }

    private TreeNode deserialize(StringBuilder data){
        if(data == null) return null;
        int i = data.indexOf(SEPARATER);
        String val = data.substring(0,i);
        data.delete(0,i+1);
        if(val.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}
