package com.pipecrafts.datastruc.list;

import lombok.Getter;
import lombok.Setter;

public class Node<T> {

  @Getter
  @Setter
//  reference to the next node
//   it's like a recursive internal object that is linked together
//   to form a list
  private Node<T> nextNode;

  @Getter
  private T nodeItem;

  public Node(T item) {
    this.nextNode = null;
    this.nodeItem = item;
  }

}
