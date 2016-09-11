package com.sky.leetcode.secondary;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SkyDream on 2016/9/8.
 */
public class _297_Serialize_and_Deserialize_Binary_Tree {

    public static void main(String args[]){
        _297_Serialize_and_Deserialize_Binary_Tree test = new _297_Serialize_and_Deserialize_Binary_Tree();
        TreeNode node = new TreeNode(45);
        String se = test.serialize(node);
        System.out.println(se);
        TreeNode root = test.deserialize(se);
    }

    public static final String NULL = "#";
    public static final char SEPARATER = ',';
    public static final String END = ".";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null) sb.append(NULL+SEPARATER);
                else{
                    sb.append("" + node.val + SEPARATER);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals(NULL)) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String nodes[] = data.split(SEPARATER+"");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root); int curr = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    TreeNode left = nodes[curr].equals(NULL) ? null : new TreeNode(Integer.valueOf(nodes[curr]));
                    curr++;
                    TreeNode right = nodes[curr].equals(NULL) ? null : new TreeNode(Integer.valueOf(nodes[curr]));
                    curr++;
                    node.left = left; node.right = right;
                    queue.add(left); queue.add(right);
                }
            }
        }
        return root;
    }
}
