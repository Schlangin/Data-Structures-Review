public class Main {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("andy");
        queue.enqueue("andy");
        queue.enqueue("andy");
        queue.enqueue("andy");
        queue.enqueue("andy");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printList();
    }
}