package com.sky.basic;

/**
 * Created by SkyDream on 2016/7/19.
 */
public class _LinkedList<T> {

    Node<T> head = null;
    Node<T> tail = null;
    int length = 0;

    public static void main(String args[]){
        _LinkedList<Integer> list = new _LinkedList<>();
        list.add(1);
        list.add(2);
        list.delete(0);
        System.out.println(list.size());
    }

    class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    public void add(T data){
        if(head == tail && tail == null){
            head = new Node(data);
            tail = head;
        }else{
            tail.next = new Node(data);
            tail = tail.next;
        }
        length++;
    }

    public void add(int pos, T data){
        if(pos < 0 || pos > length)
            throw new IllegalArgumentException("wrong position!");
        int curr = 0; Node temp = head;
        while(curr < pos){
            head = head.next;
            curr++;
        }
        Node added = new Node(data);
        added.next = temp.next;
        temp.next = added;
        length++;
    }

    public void delete(int pos){
        if(pos < 0 || pos >= length)
            throw new IllegalArgumentException("wrong position!");
        if(pos == 0)
            head = head.next;
        else {
            int curr = 0;
            Node temp = head;
            while (curr < pos - 1) {
                head = head.next;
                curr++;
            }
            temp.next = temp.next.next;
        }
        length--;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
}
