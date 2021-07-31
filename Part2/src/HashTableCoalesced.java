
public class HashTableCoalesced<K,V> implements KWHashMap<K,V> {

    private HashNode<K, V>[] table;
    private int numKeys;
    private int capacity = 101;
    private double LOAD_THRESHOLD = 0.75;


    private static class Entry<K, V> {
        /**
         * The key
         */
        private K key;

        /**
         * The value
         */
        private V value;

        /**
         * Creates a new key-value pair.
         *
         * @param key   The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         *
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         *
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         *
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    private static class HashNode<K, V> {
        private Entry<K, V> data;
        private int next = -1;

        public HashNode() {
            data = null;
        }

        public HashNode(K key, V value) {
            data = new Entry<>(key, value);
        }

        public HashNode(Entry<K, V> entry) {
            data.key = entry.key;
            data.value = entry.value;
        }

    }

    /**
     * No parameter constructor
     * Default capacity: 101
     */
    public HashTableCoalesced() {
        table = new HashNode[capacity];
    }

    /**
     * Constructor
     * @param capacity the table capacity
     */
    public HashTableCoalesced(int capacity) {
        this.capacity = capacity;
        table = new HashNode[capacity];
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
        return search(index, key);
    }

    /**
     * Recursive search method
     * @param index hash value of the key
     * @param key the key to be found
     * @return the value of the key or null
     */
    private V search(int index, K key) {
        if (index == -1)
            return null;
        if (table[index] == null)
            return null;
        if (table[index].data.key.equals(key))
            return table[index].data.value;
        else
            return search(table[index].next, key);
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
        if (table[index] == null) {
            table[index] = new HashNode<>(key, value);
            numKeys++;
            double loadFactor = (double) numKeys / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }
        else if(table[index].data.key.equals(key)){
            V oldVal = table[index].data.value;
            table[index].data.value = value;
            return oldVal;
        }

        int probNum = 1;
        return quadraticProb(index, probNum, key, value);

    }

    /**
     * Calculate the next hash value
     * @param base the hash value
     * @param prob the probe count
     * @return the new hash value
     */
    private int calcIndex(int base, int prob) {
        int newIndex = (base + prob * prob) % table.length;
        if (newIndex < 0)
            newIndex += table.length;
        return newIndex;
    }

    /**
     * Recursive quadratic probe method
     * @param index the hash value
     * @param probNum the probe count
     * @param key the key
     * @param value the value
     * @return null
     */
    private V quadraticProb(int index, int probNum, K key, V value) {
        HashNode prevNode;
        int newIndex = calcIndex(index, probNum);
        if (table[newIndex] == null) {
            table[newIndex] = new HashNode<>(key, value);
            if (table[index].next == -1)
                table[index].next = newIndex;
            else {
                boolean flag = true;
                int idx = table[index].next;
                while (flag) {
                    prevNode = table[idx];
                    if (prevNode.next == -1) {
                        prevNode.next = newIndex;
                        flag = false;
                    } else
                        idx = prevNode.next;
                }
            }
            numKeys++;
            double loadFactor = (double) numKeys / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        } else if (table[newIndex].data.key.equals(key)){
            V oldVal = table[newIndex].data.value;
            table[newIndex].data.value = value;
            return oldVal;
        }
        else
            return quadraticProb(index, probNum + 1, key, value);

    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * Each non-deleted entry from the original table is reinserted
     * into the expanded table
     */
    private void rehash() {
        HashNode<K, V>[] oldTable = table;
        table = new HashNode[2 * oldTable.length];
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                put(oldTable[i].data.key, oldTable[i].data.value);
            }
        }
    }

    /**
     * Removes the entry from the map represented by the key
     * @param key the key
     * @return the value of removed entry or null
     */
    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        return remove(index, -1, key);

    }

    /**
     * Swap the values
     * @param first the index of first value
     * @param second the index of second value
     */
    private void swap(int first, int second) {
        Entry temp = table[first].data;
        table[first].data = table[second].data;
        table[second].data = temp;
    }

    /**
     * Recursive remove method
     * If an element to be deleted is found,it swap that
     * element to the end of the chain. It does the deletion on the last element.
     * @param index the hash value
     * @param prevIndex the previous hash value
     * @param key the key
     * @return the value of removed entry or null
     */
    private V remove(int index, int prevIndex, K key) {
        if (table[index] == null)
            return null;
        if (!table[index].data.key.equals(key) && table[index].next == -1)
            return null;
        if (table[index].data.key.equals(key)) {
            if (table[index].next == -1) {
                numKeys--;
                V old = table[index].data.value;
                table[index] = null;
                if (prevIndex != -1)
                    table[prevIndex].next = -1;
                return old;
            } else {
                HashNode temp = table[index];
                V old = table[index].data.value;
                int idx = index;
                while (temp.next != -1) {
                    swap(idx, temp.next);
                    idx = temp.next;
                    temp = table[temp.next];
                }
            }
        }
        return remove(table[index].next, index, key);

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty())
            return null;
        sb.append("| Hash  | |  Key  | |  Next |");
        sb.append("\n-----------------------------");
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append("\n");
                sb.append(String.format("|%7s| |%7s| |%7s|", i, "null", "null"));

            } else {
                sb.append("\n");
                int next = table[i].next;
                if (next == -1)
                    sb.append(String.format("|%7s| |%7s| |%7s|", i, table[i].data.key, "null"));
                else
                    sb.append(String.format("|%7s| |%7s| |%7s|", i, table[i].data.key, table[i].next));

            }
        }
        return sb.toString();
    }
}
