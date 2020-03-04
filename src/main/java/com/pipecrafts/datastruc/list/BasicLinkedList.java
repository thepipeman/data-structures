package com.pipecrafts.datastruc.list;

import java.util.Objects;

public class BasicLinkedList<T> implements BaseLinkedList<T> {

  private Node<T> first;
  private Node<T> last;
  private int nodeCount;

  public BasicLinkedList() {
    this.first = null;
    this.last = null;
    this.nodeCount = 0;
  }

  @Override
  public int size() {
    return this.nodeCount;
  }

  @Override
  public void add(T item) {

    if (this.first == null) {
      this.first = new Node<>(item);
      // at this point, the list is still 1 so always
      // first == last
      last = first;
    } else {
      Node<T> newNode = new Node<>(item);
      this.last.setNextNode(newNode);
      this.last = newNode;
    }

    this.nodeCount++;

  }

  @Override
  public T remove() {
    if (size() < 1) {
      throw new IllegalStateException("List is empty!");
    }

    T nodeItem = this.first.getNodeItem();
    this.first = first.getNextNode();
    this.nodeCount--;
    return nodeItem;
  }

  @Override
  public void insert(T item, int position) {
    if (size() < position) {
      throw new IndexOutOfBoundsException("Index provided is bigger than the list size.");
    }

    Node<T> currentNode = this.first;
    int i = 1;
    while (i < position && currentNode != null) {
      // set the nextNode as currentNode until the
      currentNode = currentNode.getNextNode();
      position++;
    }

    Node<T> nodeToInsert = new Node<>(item);

    // create a reference to the nextNode
    Node<T> nodeToMoveAtTheBack = currentNode.getNextNode();

    // set nodeToInsert as nextNode
    currentNode.setNextNode(nodeToInsert);
    // now set the nextNode one step behind
    nodeToInsert.setNextNode(nodeToMoveAtTheBack);
    this.nodeCount++;
  }

  @Override
  public T removeAt(int position) {

    if (size() < position) {
      throw new IndexOutOfBoundsException("Index provided is bigger than the list size.");
    }

    int index = 0;
    Node<T> currentNode = this.first;
    Node<T> prevNode = this.first;
    while (index < position && currentNode != null) {
      prevNode = currentNode;
      currentNode = currentNode.getNextNode();
      index++;
    }

    // prevNode.nextNode == currentNode.getNodeItem at this point
    T nodeItem = currentNode.getNodeItem();

    // replace the nextNode to remove it.
    prevNode.setNextNode(currentNode.getNextNode());
    this.nodeCount--;
    return nodeItem;
  }

  @Override
  public T get(int position) {

    if (size() < position) {
      throw new IndexOutOfBoundsException("Index provided is bigger than the list size.");
    }

    Node<T> currentNode = first;
    for (int i = 0; i < size(); i++) {
      if (i == position) {
        return currentNode.getNodeItem();
      }

      currentNode = currentNode.getNextNode();
    }

    return null;
  }

  @Override
  public int find(T item) {

    if (size() < 1) {
      throw new IllegalStateException("Empty LinkedList");
    }

    Node<T> currentNode = this.first;
    for (int i = 0; i < size(); i++) {
      if (Objects.equals(item, currentNode.getNodeItem())) {
        return i;
      }

      currentNode = currentNode.getNextNode();
    }
    return -1;
  }
}


