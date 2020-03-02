package com.pipecrafts.datastruc.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListQueue<T> implements BaseQueue<T> {

  private List<T> data;

  private int front;
  private int end;


  public ListQueue() {
    this.front = -1;
    this.end = -1;
    data = new ArrayList<>();
  }


  @Override
  public int size() {
    return data.size();
  }

  @Override
  public void enQueue(T item) {
    if (size() == 0) {
      front++;
      end++;
    }

    data.add(end++, item);
  }

  @Override
  public T deQueue() {

    if (front == end) {
      T item = data.get(front);
      data.remove(front);
      front = -1;
      end = -1;
      return item;
    }

    T item = data.get(front);
    data.remove(front);
    front++;
    return item;

  }

  @Override
  public boolean contains(T item) {
    return !data.isEmpty() && data.contains(item);
  }

  @Override
  public T access(int position) {
    return Optional.ofNullable(data.get(position))
      .orElse(null);
  }
}
