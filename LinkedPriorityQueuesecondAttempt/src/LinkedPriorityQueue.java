public class LinkedPriorityQueue<T extends Comparable<T>>
{
    private Node firstNode;
    private int numEntries;

    public LinkedPriorityQueue()
    {
        firstNode = null;
        numEntries = 0;
    }


    public void add(T newEntry)
    {
        Node newNode;
        if (isEmpty())
        {
            // Priority queue is empty, so add newEntry as the only entry
            newNode = new Node(newEntry, null);
            firstNode = newNode;
        }

        else if (firstNode.data.compareTo(newEntry) > 0)
        {
            // Current first node is 'larger' than the new Node.
            // For this priority queue, we want the 'smaller' entries first.
            newNode = new Node(newEntry, firstNode);
            firstNode = newNode;
        }

        else
        {
            // new entry does not go at front of priority queue. Traverse the queue to
            // find its correct location
            for (Node iterator = firstNode; iterator != null; iterator = iterator.next)
            {
                Node nextNode = iterator.next;
                if (nextNode == null)
                {
                    // New entry goes at the back of the queue.
                    newNode = new Node(newEntry, null);
                    iterator.next = newNode;
                    break;
                }
                else if (newEntry.compareTo(nextNode.data) < 0)
                {
                    newNode = new Node(newEntry, nextNode);
                    iterator.next = newNode;
                    break;
                }
            }
        }
        numEntries ++;
    }


    public T remove()
    {
        if (isEmpty())
            return null;

        T data = firstNode.data;

        // Remove front Node by pointing firstNode to firstNode.next
        firstNode = firstNode.next;
        numEntries--;
        return data;
    }


    public T peek()
    {
        if (isEmpty())
            return null;
        return firstNode.data;
    }


    public boolean isEmpty()
    {
        return numEntries == 0;
    }


    public int getSize()
    {
        return numEntries;
    }


    public void clear()
    {
        numEntries = 0;
        firstNode = null;
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

    private class Node
    {
        private T data;
        private Node next;
        private Node(T d, Node n)
        {
            data = d;
            next = n;
        }
    }
}