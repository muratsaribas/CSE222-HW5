public interface KWHashMap<K, V> {

    /**
     * Returns the value associated with the specified key.
     * If the key is not found, it returns null.
     * @param key the specified key
     * @return the value associated with the key or
     *         it returns null if the key is not found.
     */
    V get(K key);

    /**
     * Inserts the association of a key and a value into the map.
     * If the key is already present, the new value replaces the old value.
     * @param key the key
     * @param value the value
     * @return null if the key is already present,
     *  otherwise returns the old value
     */
    V put(K key, V value);

    /**
     * Removes the entry from the map represented by the key
     * @param key the key
     * @return the value of removed entry
     */
    V remove(K key);

    /**
     * Returns the number of entries in the map
     * @return the number of entries in the map
     */
    int size();

    /**
     * Return true if no elements in the map
     * @return true if no elements in the map otherwise false
     */
    boolean isEmpty();

}
