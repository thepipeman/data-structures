package com.pipecrafts.datastruc.queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class BasicQueueTest {

  @Test
  public void testBasic() {
    Queue<String> sampleQueue = new ArrayDeque<>();
    sampleQueue.add("Aaron");
    sampleQueue.add("Jane");
    sampleQueue.remove();
    System.out.println(sampleQueue);
  }

}