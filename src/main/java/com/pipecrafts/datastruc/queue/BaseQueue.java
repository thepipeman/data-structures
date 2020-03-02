package com.pipecrafts.datastruc.queue;

public interface BaseQueue<T> {

  int size();

  void enQueue(T item);

  T deQueue();

  boolean contains(T item);

  T access(int position);

}
