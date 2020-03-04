package com.pipecrafts.datastruc.list;

public interface BaseLinkedList<T> {

  int size();

  void add(T item);

  T remove();

  void insert(T item, int position);

  T removeAt(int position);

  T get(int position);

  int find(T item);

}
