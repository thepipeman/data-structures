package com.pipecrafts.datastruc.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BasicQueueTest {

  BaseQueue<String> riders = new BasicQueue<>();

  @Before
  public void setup() {
    riders.enQueue("Aaron");
    riders.enQueue("Jane");
    riders.enQueue("Faye");
    riders.enQueue("Clyde");
  }

  @Test
  public void testEnqueue() {
    assertEquals(riders.size(), 4);
  }

  @Test
  public void testDeQueueAndContains() {
    riders.deQueue();
    riders.deQueue();
    assertEquals(riders.size(), 2);
    assertFalse(riders.contains("Aaron"));
  }

  @Test
  public void testAccess() {
    String riderOnLift = riders.access(2);
    assertEquals(riderOnLift, "Faye");
  }

}