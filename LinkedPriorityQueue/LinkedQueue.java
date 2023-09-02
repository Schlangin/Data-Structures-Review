package LinkedPriorityQueue;
public class LinkedQueue {
    private Node firstNode;
    private Node lastNode;
    LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }
    public void enqueue(String anEntry) {
        Node newNode = new Node(anEntry);
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("QUEUE IS EMPTY CANT DEQUEUE");
        }
        firstNode = firstNode.next;
    }
    public String peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("QUEUE IS EMPTY");
        }
        return firstNode.data;
    }
    public boolean isEmpty(){
        if(firstNode == null || lastNode == null){
            return true;
        }
        return false;
    }
    public int size(){
        int counter = 0;
        for(Node iterator = firstNode; iterator != null; iterator=iterator.next){
            counter++;
        }
        return counter;
    }
    public void printList(){
        for(Node iterator = firstNode; iterator != lastNode.next; iterator=iterator.next){
            System.out.println(iterator.data);
        }
    }

}
class Node{
    Node next = null;
    String data;
    Node(String d){
        data = d;
    }
}