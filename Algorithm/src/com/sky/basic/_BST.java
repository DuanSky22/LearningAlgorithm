package com.sky.basic;

/**
 * Created by SkyDream on 2016/8/23.
 */
public class _BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }

        public int size(){
            return size(root);
        }

        private int size(Node x){
            if(x == null) return 0;
            return x.N;
        }

        public Value get(Key key){
            return get(key,root);
        }

        private Value get(Key key,Node root){
            if(root == null) return null;
            int cmp = key.compareTo(root.key);
            if(cmp == 0) return root.value;
            else if(cmp < 0) return get(key,root.left);
            else return get(key,root.right);
        }

        public void put(Key key,Value value){
            root = put(root,key,value);
        }

        private Node put(Node x,Key key,Value value){
            if(x == null) return new Node(key,value,1);
            int cmp = key.compareTo(x.key);
            if(cmp == 0) x.value = value;
            else if(cmp < 0) x.left = put(x.left,key,value);
            else x.right = put(x.right,key,value);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public Key min(){
            return min(root).key;
        }

        private Node min(Node x){
            if(x.left == null) return x;
            return min(x.left);
        }

        public Key max(){
            return max(root).key;
        }

        private Node max(Node x){
            if(x.right == null) return x;
            return max(x.right);
        }

        public Key floor(Key key){
            return floor(key,root).key;
        }

        private Node floor(Key key,Node x){
            if(x == null) return null; //如果为空，说明根本找不到<=key的节点。
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x; //如果相等，直接返回该节点。
            else if(cmp < 0) return floor(key,x.left); //如果根节点比key值大，得在根节点的左节点继续找。
            else{
                Node t = floor(key,x.right); //首先在根节点的右节点继续找，如果找到了，则返回该节点，如果没找到则返回根节点。
                if(t == null) return x;
                return t;
            }
        }

        /**
         * 返回排名为k的节点
         * @param k 排名
         * @return 排名为k的节点
         */
        public Key select(int k){
            return select(k,root).key;
        }

        private Node select(int k,Node x){
            if(x == null) return null;
            int t = size(x.left);
            if(t == k) return x;
            else if(t < k) return select(k-t-1,x.right);
            else return select(k,x.right);
        }

        /**
         * 返回键key的排名。
         * @param key 键
         * @return 键key的排名。
         */
        public int rank(Key key){
            return rank(key,root);
        }

        /**
         * 在以x为根节点的树中，查找键key的排名。
         * @param key 要查找的键
         * @param x 当前根节点
         * @return 要查找的键在当前根节点的位置。
         */
        private int rank(Key key,Node x){
            if(x == null) return 0;
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return size(x.left);
            else if(cmp > 0) return size(x.left) + 1 + rank(key,x.right);
            else return rank(key,x.left);
        }

        public void deleteMin(){
            root = deleteMin(root);
        }

        private Node deleteMin(Node x){
            if(x.left == null){

            }
            return null;
        }

    }
}
