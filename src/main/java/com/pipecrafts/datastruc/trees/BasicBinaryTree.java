package com.pipecrafts.datastruc.trees;

import lombok.Data;

public class BasicBinaryTree<T extends Comparable<T>> {

  private Node root;
  private int size;

  @Data
  private class Node {
    private Node left;
    private Node right;
    private Node parent;
    private T item;

    public Node(T item) {
      this.left = null;
      this.right = null;
      this.parent = null;
      this.item = item;
    }
  }

  public BasicBinaryTree() {
    this.root = null;
  }

  public int size() {
    return this.size;
  }

  public void add(T item) {
    final Node node = new Node(item);

    if (this.root == null) {
      this.root = node;
      this.size++;
    } else {
      insert(this.root, node);
    }

  }

  public boolean contains(T item) {
//    final Node node = new Node(item);

    if (this.root == null) {
      return false;
    }

    return getNode(item) != null;
//    return containsItem(this.root, node);
  }

  public boolean delete(T item) {
    boolean deleted = false;

    if (this.root == null) {
      return false;
    }


    Node currentNode = getNode(item);

    if (currentNode != null) {

      if (currentNode.getRight() == null && currentNode.getLeft() == null) {
        unlink(currentNode, null);
        deleted = true;

      } else if (currentNode.getRight() != null && currentNode.getLeft() == null) {
        unlink(currentNode, currentNode.getRight());
        deleted = true;

      } else if (currentNode.getRight() == null && currentNode.getLeft() != null) {
        unlink(currentNode, currentNode.getLeft());
        deleted = true;
      } else {

        Node child = currentNode.getLeft();
        while (child.getRight() != null && child.getLeft() != null) {
          child = child.getRight();
        }

        child.getParent().setRight(null);
        child.setLeft(currentNode.getLeft());
        child.setRight(currentNode.getRight());
        deleted = true;

      }
    }

    if (deleted) {
      this.size--;
    }

    return deleted;
  }

  // removes the current node and puts the newNode to the old reference
  private void unlink(Node currentNode, Node newNode) {

    if (currentNode == this.root) {
      newNode.setLeft(currentNode.getLeft());
      newNode.setRight(currentNode.getRight());
      this.root = newNode;
    } else if (currentNode.getParent().getRight() == currentNode) {
      currentNode.getParent().setRight(newNode);
    } else {
      currentNode.getParent().setLeft(newNode);
    }

  }

  private Node getNode(T item) {
    Node currentNode = this.root;

    while (currentNode != null) {

      int val = item.compareTo(currentNode.getItem());

      if (val == 0) {
        return currentNode;
      } else if (val < 0) {
        currentNode = currentNode.getLeft();
      } else {
        currentNode = currentNode.getRight();
      }

    }

    return null;
  }

  private boolean containsItem(Node parent, Node child) {

    if (child.getItem().compareTo(parent.getLeft().getItem()) < 0) {

      if (parent.getLeft() == null) {
        return false;
      }

      return containsItem(parent.getLeft(), child);
    } else if (child.getItem().compareTo(parent.getRight().getItem()) > 0) {

      if (parent.getRight() == null) {
        return false;
      }

      return containsItem(parent.getRight(), child);
    }

    return true;
  }

  // divid and conquer the item will be compared and detemermined if it is to be inserted
  // on the left or right node.
  private void insert(Node parent, Node child) {

    if (child.getItem().compareTo(parent.getItem()) < 0) {

      if (parent.getLeft() == null) {
        parent.setLeft(child);
        child.setParent(parent);
        size++;
      } else {
        insert(parent.getLeft(), child);
      }

    } else if (child.getItem().compareTo(parent.getItem()) > 0) {

      if (parent.getRight() == null) {
        parent.setRight(child);
        child.setParent(parent);
        this.size++;
      } else {
        insert(parent.getRight(), child);
      }

    }

  }

}
