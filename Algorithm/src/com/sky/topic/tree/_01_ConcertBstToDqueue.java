package com.sky.topic.tree;

/**
 * Created by SkyDream on 2016/8/24.
 */
public class _01_ConcertBstToDqueue {

    private class Node<Value extends Comparable<Value>>{
        private Value value;
        private Node left;
        private Node right;

        public Node(Value value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public Node max(Node x){
        if(x == null) return null;
        while(x.right != null) x = x.right;
        return x;
    }

    public Node min(Node x){
        if(x == null) return null;
        while(x.left != null) x = x.left;
        return x;
    }

    public void convert(Node root){
        if(root == null) return;
        if(root.left != null) convert(root.left);

        Node leftMax = max(root.left);
        root.left = leftMax;
        if(leftMax != null) leftMax.right = root;

        if(root.right != null) convert(root.right);

        Node rightMin = min(root.right);
        root.right = rightMin;
        if(rightMin != null) rightMin.left = root;
    }
}
