package LinkedPriorityQueue;
public class LinkedPriorityQueue<T extends Comparable<T>>{
    private Node firstNode;
    private Node lastNode;
    private int numEntries;
    LinkedPriorityQueue(){
        firstNode = null;
        lastNode = null;
    }

    public void add(T anEntry){
        Node newNode = new Node(anEntry,null);
        if(isEmpty()){ // 1st entry
            firstNode = newNode;
            lastNode = newNode;
            return;
        }
        if(firstNode.data.compareTo(anEntry) > 0){ // Checks if the firstNode is the one that needs to be changed.
            newNode.next = firstNode;
            firstNode = newNode;
            return;
        }
        Node iterator;
        for(iterator = firstNode; iterator!=null;iterator=iterator.next){
           if(anEntry.compareTo(iterator.data) < 0){ // checks if middle of list needs to be changed
               newNode.next = iterator.next;
               iterator.next = newNode;
               return;
           }
        }
        if (iterator.next == null){
            lastNode.next = newNode;
            lastNode = newNode; // Update lastNode if newNode is the new last node
        }
    }
//    public T remove(){
//
//    }
//    public T peek(){
//
//    }
    public boolean isEmpty(){
        if(firstNode == null || lastNode == null){
            return true;
        }
        return false;
    }
    public void printList(){
        for(Node iterator = firstNode; iterator!=null;iterator=iterator.next){
            System.out.println(iterator.data);
        }
    }
    class Node{
        Node next;
        T data;
        Node(T d,Node n){
            data = d;
            next = n;
        }
    }
}

