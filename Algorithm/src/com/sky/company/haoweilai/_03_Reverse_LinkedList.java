package com.sky.company.haoweilai;

/**
 * Created by DuanSky on 2016/9/21.
 */
public class _03_Reverse_LinkedList {

    /**
     * The definition of the linked list.
     */
    class Node{
        /**
         * data: The data of the node.
         */
        int data;

        /**
         * next: the next node of this node.
         */
        Node next;
    }

    /**
     * Reverse a linked list.
     * @param node the head of the linked list.
     */
    public void reverseLinkList(Node node){
        /*
        if the node is empty or has only one node,
        we don't need to reverse the linked list.
         */
        if(node == null || node.next == null) return;
        /*
        Otherwise, we should use three pointer to reverse the linked list.
        [1] last  : the last elements of the reversed linked list.
        [2] first : the first elements of the unreversed linked list.
        [2] second: the second elements of the unreversed linked list.
         */
        Node last,first,second;
        last = node; first = node.next;
        while(first != null){//if the first is null, we reverse the linked list successfully.
            second = first.next; //the second node is the next of the first node.
            first.next = last;   //we make the next of the first point at the last.
            last = first;        //then the first becomes the last.
            first = second;      //the second becomes the first.
        }

    }
}
