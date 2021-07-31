import java.util.Iterator;
import java.util.NoSuchElementException;

public class MSHashMap<K, V> implements KWHashMap<K, V>{

    private Entry<K,V>[] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);

    private class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){return key;}

        public V getValue(){return value;}

        public V setValue(V val){
            V oldVal = value;
            value = val;
            return oldVal;
        }

    }

    /**
     * No parameter constructor
     */
    public MSHashMap(){
        table = new Entry[START_CAPACITY];
    }


    /**
     * Find the given key in the map
     * @param key the key to found
     * @return the index of the given key
     */
    private int find(K key){
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;

        while (table[index] !=null && !key.equals(table[index].key)){
            index++;
            if (index >= table.length)
                index = 0;
        }
        return index;
    }

    /**
     * Returns the value associated with the specified key.
     * If the key is not found, it returns null.
     * @param key the specified key
     * @return the value associated with the key or
     * it returns null if the key is not found.
     */
    @Override
    public V get(K key) {
        int index = find(key);
        if (table[index] != null)
            return table[index].value;
        else
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
        int index = find(key);
        if (table[index] == null){
            table[index] = new Entry<K, V>(key, value);
            numKeys++;
            double loadFactor = (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }

        V oldValue = table[index].value;
        table[index].value = value;
        return oldValue;
    }

    private void rehash(){
        Entry<K, V>[] oldTable = table;
        table = new Entry[2*oldTable.length+1];
        numKeys = 0;
        numDeletes = 0;
        for (int i=0; i< oldTable.length; i++){
            if (oldTable[i] != null && oldTable[i] != DELETED)
                put(oldTable[i].key, oldTable[i].value);
        }
    }

    /**
     * Removes the entry from the map represented by the key
     * @param key the key
     * @return the value of removed entry
     */
    @Override
    public V remove(K key) {
        int index = find(key);
        if (table[index] == null)
            return null;
        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        return oldValue;
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
     * Returns the iterator
     * @return the iterator
     */
    public MapIterator mapIterator(){
        return new MapIterator();
    }

    /**
     * Returns the iterator with the specified key
     * @param key the key
     * @return the iterator
     */
    public MapIterator mapIterator(K key){
        return new MapIterator(key);
    }

    private class MapIterator implements Iterator<K>{

        private K lastKeyReturned;
        private K first;

        private int iteratedKeys = 0;
        private int index;

        /**
         * No parameter constructor
         * The iterator starts from first key in the map
         */
        public MapIterator(){
            findFirst();
        }

        /**
         * The iterator starts from the given key
         * If key is not in the map, the iterator starts from
         * first key in the map
         * @param key the given key
         */
        public MapIterator(K key){
            int idx = find(key);
            if (table[idx] == null){
                findFirst();
            }
            else{
                lastKeyReturned = table[idx].key;
                first = lastKeyReturned;
                index = idx;
            }

        }

        /**
         * Find the first key in the map
         */
        private void findFirst(){
            for (int i=0; i< table.length ; i++){
                if (table[i] != null ){
                    if (table[i].key != null){
                        lastKeyReturned = table[i].key;
                        first = lastKeyReturned;
                        index = i;
                        break;
                    }
                }
            }
        }

        /**
         * Returns true if there are still not-iterated keys in the map,
         * otherwise returns false
         * @return true if there are still not-iterated keys in the map,
         * otherwise returns false
         */
        @Override
        public boolean hasNext() {
            return iteratedKeys < size();
        }

        /**
         * Returns the next key in the map. It returns the first key when
         * there is no not-iterated key in the map.
         * @return the next key in the map, if all keys are iterated
         * returns the first key.
         */
        @Override
        public K next() {
            K last = null;
            if (!hasNext()){
                if (first != null)
                    return first;
                else
                    throw new NoSuchElementException();
            }
            while (hasNext()){
                index++;
                if (index >= table.length)
                    index = 0;
                if (table[index] != null){
                    if (table[index].key != null){
                        last = lastKeyReturned;
                        lastKeyReturned = table[index].key;
                        iteratedKeys++;
                        break;
                    }
                }
            }
            return last;
        }
    }



}
