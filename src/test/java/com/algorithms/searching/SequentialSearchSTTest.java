package com.algorithms.searching;

import com.algorithms.stdlib.StdIn;
import org.junit.Assert;
import org.junit.Test;

public class SequentialSearchSTTest {
  @Test
  public void delete() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    sequentialSearchST.put(1, "a");
    sequentialSearchST.put(2, "b");
    sequentialSearchST.put(3, "c");
    sequentialSearchST.put(4, "d");
    sequentialSearchST.delete(3);
    Iterable<Integer> keys = sequentialSearchST.keys();
    keys.forEach(key -> {
      System.out.println("key: " + key +", value: " + sequentialSearchST.get(key));
    });
  }

  @Test
  public void contains() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    sequentialSearchST.put(1, "a");
    Assert.assertTrue(sequentialSearchST.contains(1));
    Assert.assertFalse(sequentialSearchST.contains(2));
  }

  @Test
  public void isEmpty() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    Assert.assertTrue(sequentialSearchST.isEmpty());
    sequentialSearchST.put(1, "a");
    Assert.assertFalse(sequentialSearchST.isEmpty());
  }

  @Test
  public void keys() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    sequentialSearchST.put(1, "a");
    sequentialSearchST.put(2, "b");
    sequentialSearchST.put(3, "c");
    sequentialSearchST.put(4, "d");
    Iterable<Integer> keys = sequentialSearchST.keys();
    keys.forEach(key -> {
      System.out.println("key: " + key +", value: " + sequentialSearchST.get(key));
    });
  }

  @Test
  public void put() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    sequentialSearchST.put(1, "a");
    sequentialSearchST.put(2, "b");
    sequentialSearchST.put(3, "c");
    sequentialSearchST.put(4, "d");
    Assert.assertEquals(4, sequentialSearchST.size());
  }

  @Test
  public void get() throws Exception {
    SequentialSearchST<Integer, String> sequentialSearchST = new SequentialSearchST<>();
    Assert.assertNull(sequentialSearchST.get(1));
    sequentialSearchST.put(1, "a");
    sequentialSearchST.put(2, "b");
    sequentialSearchST.put(3, "c");
    sequentialSearchST.put(4, "d");
    Assert.assertEquals("d", sequentialSearchST.get(4));
  }
}
