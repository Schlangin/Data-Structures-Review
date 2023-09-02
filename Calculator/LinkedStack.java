package Calculator;
public class LinkedStack<T> {
    Node firstNode; // comment
    LinkedStack(){
        firstNode = null;
    }
    public void push(T anEntry){
        Node newNode = new Node(anEntry);
        if(isEmpty()){
            firstNode = newNode;
            return;
        }
        newNode.next = firstNode;
        firstNode=newNode;
    }
    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("STACK IS EMPTY");
        }
        Node temp = firstNode;
        firstNode = firstNode.next;

        return temp.data;
    }
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("STACK IS EMPTY");
        }
        return firstNode.data;
    }
    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        int size = 0;
        for(Node iterator = firstNode;iterator!=null;iterator = iterator.next){
            size++;
        }
        return size;
    }
    public void clear(){
        firstNode=null;
        firstNode.next = null;
    }
    private class Node{
        Node next = null;
        T data;
        Node(T d){
            data = d;
        }
    }
}

