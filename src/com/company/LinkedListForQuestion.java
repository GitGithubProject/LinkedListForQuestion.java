package com.company;

/// <summary>
/// Name Nahom Gebreyohannies
/// Midterm Project
/// Course CSI 345 Winter 2021
/// Instructor
/// </summary>

import java.util.NoSuchElementException;
import java.util.Stack;


public class LinkedListForQuestion{

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void displayLink() // display ourself
        {
            System.out.print("{" + value + "} ");
        }

    }

    private Node first;
    private Node last;
    private int size;
    /**
     * Reverse the linked list
     */

    public void print() {

        Node current = first;//equivalent to int i =0
        while (current != null) {// i <size

            System.out.print(current.value + " ");//array[i]
            current = current.next;//i++
        }

    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Node current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println(" ");
    }

    public void addLast(int item) {

        //first wrapp the int item inside the node objct
        // make new link
        var newNode = new Node(item);

        if (isEmpty()) {

            first = last = newNode;
        } else {
            // last --> newLink
            last.next = newNode;
            //set the last node to node
            // last --> newlink
            last = newNode;
        }

        size++;
    }

    public void addFirst(int item) {

        // make new link
        var newNode = new Node(item);

        if (isEmpty()) {

            first = last = newNode;

        } else {

            // newLink --> old first
            newNode.next = first;

            // first --> newLink
            first = newNode;

        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    // delete first item
    public void deleteFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;

        } else {
            var second = first.next;

            first.next = null;
            first = second;
        }
        size--;
    }

    public void removelast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;

        } else {

            var current = first;
            while (current != null) {

                if (current.next == last) {
                    break;
                } else {

                    current = current.next;
                }

            }
        }

        size--;

    }

    private Node getPrevious(Node node) {

        var current = first;

        while (current != null) {

            if (current.next == node) {
                return current;
            } else {

                current = current.next;
            }

        }
        return null;
    }

    //0(1)
    public int size() {

        return size;
    }

    public int[] toArray() {

        int[] array = new int[size];

        var current = first;
        var index = 0;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
        }

        return array;
    }

    //Method that take array and its size and convert it to linkedlist
    // used inquestion 4
    public Node arrayToList(int[] arr,int n){
        Node root = null;
        n = arr.length;
        for (int i = n - 1; i >= 0 ; i--)
            addFirst(arr[i]);
        return root;
    }

    //Question 4. Write a method that takes a sorted array of ints and removes
    //all the duplicates using likedlist
    public void removeDuplicate(int[] arr, int size) {

        arrayToList(arr, size);
        //If root node is null
        if(isEmpty()) {
            throw  new NoSuchElementException();
        }
        // size of linked list is 1
        if(size == 1) {
            return;
        }
        // sort the linked list
        bubbleSortList();

        Node currentNode = first;
        Node nextNode = first.next;

        while(nextNode != null) {
            if(currentNode.value == nextNode.value) {
                currentNode.next = nextNode.next;

                nextNode=currentNode.next;
                size--;
            }
            else {
                nextNode=nextNode.next;
                currentNode=currentNode.next;

            }
        }
    }

    //Question 5 method that reverse the linkedlist
    public void  reverseLikedList(){

        if (isEmpty()) {
            return;
        }
        // size of linked list is 1
        if(size == 1) {
            return;
        }
        var previous = first;
        var current = first.next;

        while (current != null){

            var next = current.next;
            current.next = previous;
            previous = current;
            current= next;
        }

        last=first;
        last.next= null;
        first = previous;

    }

    //Question 6 Bubble sort for the linkedlist
    public void bubbleSortList(){

        // Node current will point to head
         Node current = first, index = null;

        int temp;

        if (first == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.value > index.value) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }


    //Question 8. Write a method that removes duplicates from a sorted linked list use stack
    public void removeDuplicateUsingStack() {
        // Push all node  to Stack starting from root
        Stack<Node> uniquestack = new Stack<>();

        Node currentNode = first;

        if(currentNode != null) {

            uniquestack.push(currentNode);
            currentNode = currentNode.next;
        }

        while(currentNode !=null) {

            //if the top element is different from the currently visited node then push it to stack
            if(uniquestack.peek().value != currentNode.value) {
                uniquestack.push(currentNode);
            }
            currentNode=currentNode.next;
        }


        if(!uniquestack.isEmpty()) {
            Node n = uniquestack.pop();
            last = n;
            n.next = null;
            while (!uniquestack.isEmpty())  {       //peak at the next value and compare it with previous value n
                Node current=uniquestack.pop();
                 current.next = n;
                 n =current;
            }
            first =n;
        }

    }


    public static void main(String[] args) {

        LinkedListForQuestion list = new LinkedListForQuestion();

        list.addFirst(10);
        list.addFirst(180);
        list.addFirst(30);
        list.addFirst(70);
        list.addFirst(40);
        list.addFirst(90);
        list.addFirst(70);
        list.addFirst(70);
        list.addFirst(40);

        //Question 4
        //declare and create array
        int[] arr = {7, 10,10, 12, 15, 17, 17, 17, 17, 20, 25, 33, 40,40,40, 45, 45,  49};

        // size of array
        int size = arr.length;

        System.out.println("\nContent of linkedlist after item added from array");

        //method that add given array value to linkedlist using add first method
        list.arrayToList(arr, size);
        System.out.println(" ");
        //display the linkedlist
        list.print();
        System.out.println(" ");
        System.out.println("\nContent of linkedlist after removing all duplicate method");

        // method that remove duplicate taking arr and its size as input
        list.removeDuplicate(arr, size);
        list.print();

        System.out.println(" ");
        list.addFirst(10);
        list.addFirst(180);
        list.addFirst(30);
        list.addFirst(70);
        list.addFirst(40);
        list.addFirst(90);
        list.addFirst(70);
        list.addFirst(70);
        list.addFirst(40);
        list.addFirst(70);
        list.addFirst(80);
        list.addFirst(90);

        //Question 8
        System.out.println("\nContent of linkedlist before applying remove duplicate method using stack");
        list.print();

        System.out.println(" ");
        System.out.println("\nContent of linkedlist after applying remove duplicate method using stack");

        // sort the linked list before apply remove duplicate method
        list.bubbleSortList();

        // apply the remove method
        list.removeDuplicateUsingStack();
        System.out.println();

        //display the result
        list.print();

        System.out.println(" ");
        System.out.println("\nContent of linked list before applying reverse method\n");

        //display the result
        list.print();
        //method that reverse the linked list
        list.reverseLikedList();

        System.out.println("\nContent of linked list after applying reverse method\n");
        //display the result
        list.print();

    }

}
