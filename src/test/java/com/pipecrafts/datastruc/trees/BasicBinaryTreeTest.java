package com.pipecrafts.datastruc.trees;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class BasicBinaryTreeTest {

  final BasicBinaryTree<String> basicBinaryTree = new BasicBinaryTree<>();

  @Before
  public void setup() {
    basicBinaryTree.add("Ganadin");
    basicBinaryTree.add("Rasing");
    basicBinaryTree.add("Evenagelista");
  }

  @Test
  public void testAddAndSize() {
    assertEquals(3, basicBinaryTree.size());
  }

  @Test
  public void testContains() {
    assertTrue(basicBinaryTree.contains("Rasing"));
    assertFalse(basicBinaryTree.contains("Aguilar"));
  }

  @Test
  public void testRemove() {
    assertTrue(basicBinaryTree.delete("Rasing"));
    assertEquals(2, basicBinaryTree.size());

    assertFalse(basicBinaryTree.delete("Aguilar"));
    assertEquals(2, basicBinaryTree.size());
  }


}
