public class Main {
    public static void main(String[] args) {
        LinkedPriorityQueue<String> wordQueue = new LinkedPriorityQueue<>();

        wordQueue.add("apple");
        wordQueue.add("banana");
        wordQueue.add("grape");
        wordQueue.add("orange");
        wordQueue.add("kiwi");
        System.out.println("Priority Queue contents:");
        System.out.println(wordQueue);
    }
}