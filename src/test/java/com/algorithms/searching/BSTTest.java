package com.algorithms.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {


  private BST<Integer, String> bst;
  @Before
  public void setUp() {
    bst = new BST<>();
    bst.put(16, "a");
    bst.put(9, "b");
    bst.put(8, "c");
    bst.put(29, "d");
    bst.put(3, "e");
    bst.put(30, "f");
    bst.put(6, "g");
    bst.put(2, "h");
  }

  @Test
  public void min() throws Exception {
    Assert.assertEquals(2, bst.min().intValue());
  }

  @Test
  public void minTest2() throws Exception {
    Assert.assertNull(new BST<>().min());
  }

  @Test
  public void put() throws Exception {

    System.out.println(bst.size());
    System.out.println(bst.get(3));
    System.out.println(bst.get(333));
  }

  @Test
  public void get() throws Exception {
  }

  @Test
  public void delete() throws Exception {
  }

  @Test
  public void contains() throws Exception {
  }

  @Test
  public void isEmpty() throws Exception {
  }

  @Test
  public void size() throws Exception {
  }

  @Test
  public void keys() throws Exception {
  }

}