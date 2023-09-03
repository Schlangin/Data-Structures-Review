import java.util.Comparator;
public class PriorityQueue<T extends Comparable<T>>{
    private Node firstNode;
    private int queueSize;
    PriorityQueue(){
        firstNode = null;
        queueSize = 0;
    }
    public void add(T anEntry){
        Node newNode;
        if(isEmpty()){
            newNode = new Node(anEntry,null);
            firstNode = newNode;
            return;
        }
        if(firstNode.data.compareTo(anEntry) > 0){
            newNode = new Node(anEntry,firstNode);
            firstNode = newNode;
            return;
        }
        Node iterator;
        for(iterator = firstNode;iterator!=null;iterator=iterator.next){
            if(iterator.next == null){
                newNode = new Node(anEntry,null);
                iterator.next = newNode;
                return;
            }
            if(anEntry.compareTo(iterator.next.data) < 0){
                newNode = new Node(anEntry,iterator.next);
                iterator.next = newNode;
                return;
            }
        }
        queueSize++;
    }
    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Node iterator = firstNode; iterator != null; iterator = iterator.next)
        {
            sb.append(iterator.data).append(" ");
        }
        return sb.toString();
    }
    class Node{
        Node next;
        T data;
        Node(T d,Node n){
            next = n;
            data = d;
        }
    }
}
