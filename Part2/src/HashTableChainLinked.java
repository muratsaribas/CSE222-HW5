import java.util.Iterator;
import java.util.LinkedList;

public class HashTableChainLinked<K, V> implements KWHashMap<K, V> {

    private LinkedList< Entry<K,V> >[] table;
    private int numKeys;
    private int capacity = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    private static class Entry<K,V>{
        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    /**
     * No parameter constructor
     * Default capacity: 101
     */
    public HashTableChainLinked(){
        table = new LinkedList[capacity];
    }

    /**
     * Constructor
     * @param capacity the table capacity
     */
    public HashTableChainLinked(int capacity){
        if (capacity > 0){
            this.capacity = capacity;
            table = new LinkedList[capacity];
        }
        else
            table = new LinkedList[this.capacity];

    }

    /**
     * Returns the value associated with the specified key.
     * If the key is not found, it returns null.
     * @param key the specified key
     * @return the value associated with the key or
     *         it returns null if the key is not found.
     */
    @Override
    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null;

        for (Entry<K,V> nextItem : table[index]){
            if (nextItem.key.equals(key))
                return nextItem.value;
        }

        return null;
    }

    /**
     * Inserts the association of a key and a value into the map.
     * If the key is already present, the new value replaces the old value.
     * @param key the key
     * @param value the value
     * @return null if the key is already present,
     *  otherwise returns the old value
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index]==null)
            table[index] = new LinkedList< Entry<K,V> >();

        for (Entry<K,V> nextItem : table[index]){
            if (nextItem.key.equals(key)){
                V oldValue = nextItem.value;
                nextItem.setValue(value);
                return oldValue;
            }
        }

        table[index].addFirst(new Entry<K,V>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    /**
     * Removes the entry from the map represented by the key
     * @param key the key
     * @return the value of removed entry
     */
    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null;

        Iterator<Entry<K,V>> iter = table[index].iterator();
        while (iter.hasNext()){
            Entry<K,V> nextItem = iter.next();
            if (nextItem.key.equals(key)){
                V returnValue = nextItem.value;
                iter.remove();
                numKeys--;
                if (table[index].isEmpty())
                    table[index] = null;
                return returnValue;
            }
        }
        return null;
    }

    /**
     * Returns the number of entries in the map
     * @return the number of entries in the map
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * Return true if no elements in the map
     * @return true if no elements in the map otherwise false
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * Each non-deleted entry from the original table is reinserted
     * into the expanded table
     */
    private void rehash(){
        LinkedList<Entry<K,V>>[] oldTable = table;
        table = new LinkedList[2*oldTable.length +1];
        numKeys = 0;
        for (int i=0; i< oldTable.length; i++){
            if (oldTable[i] != null){
                for (Entry<K,V> nextEntry : oldTable[i])
                    put(nextEntry.key, nextEntry.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty())
            return null;
        sb.append("\n| Hash  | |  Key  |");
        sb.append("\n-------------------");
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append("\n");
                sb.append(String.format("|%7s| |%7s|", i, "null"));

            } else {
                sb.append("\n");
                sb.append(String.format("|%7s| |%7s|", i, table[i].get(0).key));
                boolean flag=true;
                for (Entry<K,V> nextEntry : table[i]){
                    if(flag)
                        flag = false;
                    else
                        sb.append("-->" + nextEntry.key);
                }
            }
        }
        return sb.toString();
    }
}
