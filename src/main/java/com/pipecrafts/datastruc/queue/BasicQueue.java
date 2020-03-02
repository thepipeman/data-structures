package com.pipecrafts.datastruc.queue;


import java.util.Objects;

public class BasicQueue<T> {

  private T[] data;

  // start of queue
  private int front;

  //  end of queue
  private int end;

  public BasicQueue(int size) {
    this.front = -1;
    this.end = -1;
    data = (T[]) new Object[size];
  }

  public BasicQueue() {
    this(1000);
  }

  public int size() {
    if (front == -1 && end == -1) {
      return 0;
    }

    return (end - front) + 1;
  }

  public void enQueue(T item) {

    if ((end + 1) % data.length == front) {
      throw new IllegalStateException("The Queue is full!");
    }

    if (size() == 0) {
      // this is needed because initially fronte and end are both -1
      front++;
      data[++end] = item;
    } else {
      data[++end] = item;
    }

  }

  public T deQueue() {

    if (size() == 0) {
      throw new IllegalStateException("Queue is empty!");
    }

    if (front == end) {
      T item = data[front];
      data[front] = null;
      front = -1;
      end = -1;
      return item;
    }

    // FIFO
    T item = data[front];
    data[front] = null;
    front++;
    return item;
  }

  public boolean contains(T item) {
    for (T dataItem : data) {
      if (Objects.equals(dataItem, item)) {
        return true;
      }
    }

    return false;

  }

  public T access(int position) {

    if (size() < 1) {
      throw new IllegalStateException("Queue is empty bitch!");
    }

    return data[position];
  }

}
