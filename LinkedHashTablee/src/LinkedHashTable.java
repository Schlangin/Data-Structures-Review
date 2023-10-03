public class LinkedHashTable<K, V>
{
    private static final int DEFAULT_NUM_BUCKETS = 10;
    private static final int MAX_NUM_BUCKETS = 1000;
    private TableEntry[] buckets;
    private int numEntries;
    public LinkedHashTable()
    {
        this(DEFAULT_NUM_BUCKETS);
    }
    public LinkedHashTable(int size)
    {
        if (size > MAX_NUM_BUCKETS)
        {
            throw new IllegalStateException("Cannot create a hash table with " + size + " buckets!");
        }
        @SuppressWarnings("unchecked")
        TableEntry[] tempBuckets = (TableEntry[]) new LinkedHashTable<?, ?>.TableEntry[size];
        buckets = tempBuckets;
        numEntries = 0;
    }
    private int getHashIndex(K key)
    {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public boolean isEmpty()
    {
        return numEntries == 0;
    }

    public int getSize()
    {
        return numEntries;
    }
    public V add(K key, V value)
    {
        int index = getHashIndex(key);

        // TODO: buckets[index] is the head pointer of the linked list we want to add the key/value pair to.
        //  It will either be null or reference the first TableEntry in the list
        //  Scenarios:  bucket is empty.
        //              Key exists in a TableEntry in the bucket. Replace and return the old value.
        //              bucket is empty, key does not exist. Add new TableEntry to front

        return null;
    }
    public V remove(K key)
    {
        int index = getHashIndex(key);
        // TODO: buckets[index] is the head pointer of the linked list we want to remove key/value pair from
        //  It will either be null or reference the first TableEntry in the list
        //  Scenarios:  First TableEntry in bucket is one we're removing.
        //              Any other TableEntry in bucket is one we're removing.
        //  Method should return the value associated with the given key
        return null;
    }
    public V getValue(K key){
        int bucketIndex = getHashIndex(key);
        // get head of linked list in given index
        TableEntry iterator = buckets[bucketIndex];

        while(iterator != null){
            if(iterator.key.equals(key)){
                return iterator.value;
            }
            iterator = iterator.next;
        }
        return null;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++)
        {
            sb.append("Bucket #").append(i).append(": ");
            for (TableEntry iterator = buckets[i]; iterator != null; iterator = iterator.next)
            {
                sb.append(iterator).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    private class TableEntry
    {
        private K key;
        private V value;
        private TableEntry next;

        private TableEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString()
        {
            return "(" + key + ", " + value + ")";
        }
    }
}
