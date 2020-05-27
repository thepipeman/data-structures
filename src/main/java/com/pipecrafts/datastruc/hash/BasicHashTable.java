package com.pipecrafts.datastruc.hash;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

public class BasicHashTable<K, V> {

  public BasicHashTable(int capacity) {
    this.capacity = capacity;
    this.data = new Entry[this.capacity];
    this.size = 0;
  }

  private Entry<K, V>[] data;
  private int capacity;

  private int size;

  public int size() {
    return size;
  }

  public void put(K key, V value) {
    int hash = calculateHash(key);
    data[hash] = new Entry<>(key, value);
    this.size++;
  }

  public V get(K key) {
    int hash = calculateHash(key);

    return Optional.ofNullable(data[hash])
      .map(e -> (V) e.getValue())
      .orElse(null);
  }

  public V delete(K key) {
    V value = get(key);

    if (value == null) {
      return null;
    }

    int hash = calculateHash(key);
    data[hash] = null;
    size--;

    // move hash up and then check if the next slot is present
    hash = moveHashUp(hash);

    // if the next slot is present, then perform a rehash of the succeeding entries.
    while (data[hash] != null) {
      Entry<K, V> entry = data[hash];

      // remove the entry from its old hash
      data[hash] = null;
      // add it again to perform the rehashing
      put(entry.getKey(), entry.getValue());
      // the item was repositioned, therefore the size should be decreased
      size--;
      // move hash up and again to continue the loop until there's no item.
      hash = moveHashUp(hash);
    }

    return value;
  }

  public boolean hasKey(K key) {
    int hash = calculateHash(key);

    if (data[hash] == null) {
      return false;
    }

    return data[hash].getKey().equals(key);
  }

  public boolean hasValue(V value) {
    for (int i = 0; i < this.capacity; i++) {
      Entry<K, V> entry = data[i];


      if (entry != null && entry.getValue().equals(value)) {
        return true;
      }
    }

    return false;
  }

  private int calculateHash(K key) {
    int hash = key.hashCode() % this.capacity;

    while (data[hash] != null && !data[hash].getKey().equals(key)) {
      hash = moveHashUp(hash);
    }

    return hash;
  }

  private int moveHashUp(int hash) {
    return (hash + 1) % this.capacity;
  }

  @Data
  @AllArgsConstructor
  private class Entry<K, V> {
    private K key;
    private V value;
  }

}
