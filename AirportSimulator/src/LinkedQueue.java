public class LinkedQueue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T anEntry) {
        Node<T> newNode = new Node<>(anEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("QUEUE IS EMPTY, CANNOT DEQUEUE");
        }
        firstNode = firstNode.next;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("QUEUE IS EMPTY");
        }
        return firstNode.data;
    }

    public boolean isEmpty() {
        return firstNode == null || lastNode == null;
    }

    public int size() {
        int counter = 0;
        for (Node<T> iterator = firstNode; iterator != null; iterator = iterator.next) {
            counter++;
        }
        return counter;
    }

    public void printList() {
        for (Node<T> iterator = firstNode; iterator != lastNode.next; iterator = iterator.next) {
            System.out.println(iterator.data);
        }
    }
}

class Node<T> {
    Node<T> next = null;
    T data;

    Node(T d) {
        data = d;
    }
}
