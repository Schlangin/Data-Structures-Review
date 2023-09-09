import java.util.Comparator;
public class PriorityQueue<T> {
    Node firstNode;
    Node lastNode;
    PriorityQueue(){
        firstNode = null;
        lastNode = null;
    }
    public void enqueue(T input , int priority){
        Node newNode = new Node(input,priority,null);
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            return;
        }
        if(newNode.priority < firstNode.priority){
            newNode.next = firstNode;
            firstNode = newNode;
            return;
        }
        for (Node temp = firstNode; temp.next != null; temp = temp.next) {

            if(newNode.priority < temp.next.priority){
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
        }
        lastNode.next = newNode;
        lastNode = newNode;
    }
    public T dequeue(){
        Node temp = firstNode;
        if(isEmpty()){
            throw new IllegalStateException("THE QUEUE IS EMPTY");
        }
        firstNode = firstNode.next;
        if(firstNode == null){
            //queue is empty update lastNode as well
            lastNode=null;
        }
        return temp.data;
    }
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("QUEUE IS EMPTY");
        }
        return firstNode.data;
    }
    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }
    public <T> int size() {
        int counter = 0;
        for (Node iterator = firstNode; iterator != null; iterator = iterator.next) {
            counter++;
        }
        return counter;
    }
    public T getFront(){
        return firstNode.data;
    }
    public void clear(){
        firstNode = null;
        lastNode = null;
    }

    private class Node{
        T data;
        Node next;
        int priority;
        Node(T data,int priority,Node next){
            this.priority = priority;
            this.next = next;
            this.data = data;
        }
    }
}
