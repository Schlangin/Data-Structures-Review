public class LinkedList {
    // The head pointer
    private Node firstNode = null;
    private Node lastNode = null;

    public void add(String newEntry){
        if(firstNode == null && lastNode == null){
            Node newNode = new Node(newEntry);
            firstNode = newNode;
            lastNode = newNode;
        }else {
            Node newNode = new Node(newEntry); // create new node
            newNode.next = firstNode; // makes new Nodes .next = first node
            firstNode = newNode; // turns newNode into first Node
        }
    }
    private void displayChain(Node nodeToPrint){
        if(nodeToPrint != null){
            displayChain(nodeToPrint.next);
            System.out.println(nodeToPrint.data);
        }
    }
    public void display(){
        displayChain(firstNode);
    }
    public void addToIndex(String anEntry, int index){
        if(index == 0){
            add(anEntry);
        }else{
            Node iterator = firstNode;
            int curIndex = 0;
            while(curIndex < index - 1){
                if(iterator == null){
                    throw new IndexOutOfBoundsException("Invalid index: " + index);
                }
                iterator = iterator.next;
                curIndex++;
            }
            Node newNode = new Node(anEntry);
            newNode.next = iterator.next;
            iterator.next=newNode;
        }
    }
    public void addToEnd(String anEntry){
       if(firstNode == null){
           add(anEntry);
           return;
       }
       Node myNode = new Node(anEntry);
       lastNode.next = myNode;
       lastNode = myNode;
    }
    public void addAfter(String anEntry, String valueToAddAfter){

        for (Node iterator = firstNode; iterator!=null ; iterator = iterator.next) {
            if(iterator.data.equals(valueToAddAfter)){
                Node newNode = new Node(anEntry);
                newNode.next = iterator.next;
                iterator.next = newNode;
                break;
            }
        }
    }
    public boolean remove(String target){
        if(firstNode == null){
            throw new IndexOutOfBoundsException("Linked List is empty cannot remove");
        }
        if(firstNode.data.equals(target)){
            firstNode = firstNode.next;
            if(firstNode==null){
                lastNode=null; // handles case where list becomes empty
            }
            return true;
        }

        //See if the node we need to remove is elsewhere in the List
        for(Node iterator = firstNode; iterator!=null;iterator=iterator.next){
            Node nextNode = iterator.next;
            if(nextNode != null && nextNode.data.equals(target)){
                iterator.next = nextNode.next;
                return true;
            }
        }
        return false;
    }
    public void printList(){
        for(Node iterator= firstNode; iterator != null; iterator = iterator.next){
            System.out.println(iterator.data + " ");
        }
    }

    public boolean isInList(String s){
        for(Node iterator = firstNode; iterator != null; iterator = iterator.next){
            if(iterator.data.equals(s)){
                return true;
            }
        }
        return false;
    }
    public int countOccurences(String value){
        int counter = 0;
        for (Node iterator = firstNode; iterator != null ; iterator = iterator.next) {
            if(iterator.data.equals(value)){
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }

    private class Node {
        public String data;
        public Node next = null;

        public Node(String s) {
            data = s;
        }
    }
}

