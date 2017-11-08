package com.algorithms.searching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchSTTest {
  private BinarySearchST<Integer, String> binarySearchST;
  @Before
  public void setUp() throws Exception {
    binarySearchST = new BinarySearchST<>(30);
  }

  @Test
  public void put() throws Exception {
    binarySearchST.put(1, "a");
    binarySearchST.put(9, "b");
    binarySearchST.put(3, "c");
    binarySearchST.put(2, "d");
    binarySearchST.put(5, "e");
    System.out.println(binarySearchST.toString());
  }

  @Test
  public void get() throws Exception {
    put();
    System.out.println(binarySearchST.get(4));
    System.out.println(binarySearchST.get(5));
    System.out.println(binarySearchST.get(9));
  }

  @Test
  public void delete() throws Exception {
    put();
    binarySearchST.delete(3);
    System.out.println( binarySearchST.toString());
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