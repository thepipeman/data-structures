package com.pipecrafts.datastruc.hash;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class BasicHashTableTest {

  BasicHashTable<Long, String> sampleHashTable = new BasicHashTable<>(12);

  @Before
  public void setup() {
    sampleHashTable.put(1L, "Developer");
    sampleHashTable.put(2L, "Manager");
    sampleHashTable.put(3L, "CEO");
    sampleHashTable.put(4L, "Consultant");
  }

  @Test
  public void testPut() {
    assertEquals(4, sampleHashTable.size());
  }

  @Test
  public void testGet() {
    assertEquals("Developer", sampleHashTable.get(1L));
    assertEquals("Manager", sampleHashTable.get(2L));
  }

  @Test
  public void testDelete() {
    assertEquals("Developer", sampleHashTable.delete(1L));
    assertEquals(3, sampleHashTable.size());
  }

  @Test
  public void testHasKey() {
    assertTrue(sampleHashTable.hasKey(1L));
    assertFalse(sampleHashTable.hasKey(10L));
  }

  @Test
  public void testHasValue() {
    assertTrue(sampleHashTable.hasValue("Developer"));
    assertFalse(sampleHashTable.hasValue("QA"));
  }

}
