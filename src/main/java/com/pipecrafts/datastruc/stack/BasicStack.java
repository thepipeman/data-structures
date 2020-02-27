package com.pipecrafts.datastruc.stack;

public class BasicStack<T> {

  private T[] data;
  private int stackPointer;

  public BasicStack() {
    this.data = (T[]) new Object[1000];
    this.stackPointer = 0;
  }

  public void push(T item) {
    data[this.stackPointer++] = item;
  }

  public T pop() {
    if (this.stackPointer == 0) {
      throw new IllegalStateException("No more items on the stack");
    }

    return data[--this.stackPointer];
  }

  public boolean contains(T item) {
    for (T d : data) {
      if (d.equals(item)) {
        return true;
      }
    }

    return false;
  }

  public T access(T item) {

    while (stackPointer > 0) {
      T tmpItem = pop();
      if (tmpItem.equals(item)) {
        return tmpItem;
      }
    }

    throw new IllegalStateException("Could not find item in the stack");
  }

  public int size() {
    return this.stackPointer;
  }

}
