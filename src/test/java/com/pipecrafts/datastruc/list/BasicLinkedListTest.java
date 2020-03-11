package com.pipecrafts.datastruc.list;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BasicLinkedListTest {

  BaseLinkedList<String> sampleList = new BasicLinkedList<>();

  @Before
  public void setup() {
    sampleList.add("Aaron");
    sampleList.add("Jane");
    sampleList.add("Faye");
    sampleList.add("Clyde");
  }

  @Test
  public void testAdd() {
    assertEquals(sampleList.size(), 4);
  }

  @Test
  public void remove() {
    String removedItem = sampleList.remove();
    assertEquals("Aaron", removedItem);
  }

  @Test
  public void testInsertAndGet() {
    sampleList.insert("John", 0);

    assertEquals("John", sampleList.get(0));
    assertEquals("Aaron", sampleList.get(1));
  }

  @Test
  public void testRemovAt() {
    String removedItem = sampleList.removeAt(1);
    assertEquals("Jane", removedItem);
    assertEquals(sampleList.size(), 3);
    assertEquals(sampleList.get(1), "Faye");
  }

  @Test
  public void testFind() {
    assertEquals(0, sampleList.find("Aaron"));
    assertEquals(3, sampleList.find("Clyde"));
  }

}