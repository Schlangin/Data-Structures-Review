public class MyHashTable<K,V> {
    private int numEntries;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAX_CAPACITY = 10000;
    private TableEntry[] entries;
    public MyHashTable(){
        this(DEFAULT_CAPACITY);
    }
    public MyHashTable(int size){
        checkSize(size);
        @SuppressWarnings("unchecked")
        TableEntry[] temp = (TableEntry[]) new MyHashTable.TableEntry[size];
        entries = temp;
        numEntries = 0;
    }
    //add the value to the index that 'key' maps to
    public void add(K key, V value){
        if(key == null || value == null){
            throw new IllegalArgumentException();
        }
        int index = getHashIndex(key);
        index = probe(index , key);
        if(entries[index] == null || entries[index].isRemoved){
            //an entry for this key doesnt exIst in the hash table insert a new table entry
            entries[index] = new TableEntry(key,value);
            numEntries++;
        }else{
            // An entry for 'key' exists in the hash table. overwrite its 'value'
            entries[index].setValue(value);
        }
    }
    public void remove(K key){
        int index = getHashIndex(key);
        index = probe(index,key);
        if(entries[index] != null && entries[index].isIn() && entries[index].getKey().equals(key)){
            entries[index].setRemoved();
        }
    }
    public V getValue(K key){
        int index = getHashIndex(key);
        // Probe returns (in order of priority)
        // 1. The index of the TableEntry contains the given key
        // 2. The first 'avaliable' index after where the key hashes
        // 3. The first null index after the key hashes
        index = probe(index,key);
        if(entries[index] != null && entries[index].isIn() && entries[index].getKey().equals(key)){
            return entries[index].getValue();
        }
        return null;
    }
    private int probe(int index, K key){
        //Flag to track whether the key was found already in the hashtable in a tableentry set to 'in'
        boolean keyFound = false;

        // To track the first index with a TableEntry set to 'removed'
        int firstAvailableIndex = -1;

        //loop until the key is found in an 'in' TableEntry or null is reached
        while(!keyFound && entries[index] != null){
            if(entries[index].isIn()){
                if(key.equals(entries[index].getKey())){
                    keyFound = true;
                }else{
                    index = index + 1 % entries.length;
                }
            }
            else{
                //this TableEntry has been removed from the hash tab;e and set to 'Removed'
                if(firstAvailableIndex == -1){
                    firstAvailableIndex = index;
                    index = (index + 1) % entries.length;
                }
            }
        }
        if(keyFound || firstAvailableIndex == -1){
            return index;
        }
        return firstAvailableIndex;
    }
    private int getHashIndex(K key){
        return Math.abs(key.hashCode()) % entries.length;
    }
    private void enlargeHashTable(){
        TableEntry[] oldTable = entries;
        int oldSize = oldTable.length;
        int newSize = oldSize * 2;
        checkSize(newSize);

        @SuppressWarnings("unchecked")
        TableEntry[] temp = (TableEntry[]) new MyHashTable.TableEntry[newSize];
        entries = temp;

        for(int index = 0; index < oldSize; index++){
            if(oldTable[index] != null && oldTable[index].isIn()){
                //index isnt null and tableentry it holds still represents an entry in the hashtable

                add(oldTable[index].getKey(),oldTable[index].getValue());
            }
        }
    }
    private void checkSize(int size){
        if(size > MAX_CAPACITY){
            throw new IllegalStateException();
        }
    }
    public void printEntries(){
        for (int i = 0; i < entries.length; i++) {
            System.out.println(entries[i].getValue());
        }
    }
    private class TableEntry{
        private K key;
        private V value;
        private boolean isRemoved;

        public TableEntry(K newKey, V newValue){
            key = newKey;
            value = newValue;
            isRemoved = false;
        }
        public boolean isRemoved(){
            return isRemoved;
        }
        public boolean isIn(){
            return !isRemoved;
        }
        public void setRemoved(){
            isRemoved = true;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }

        public void setValue(V newValue){
            value = newValue;
        }
    }
}
