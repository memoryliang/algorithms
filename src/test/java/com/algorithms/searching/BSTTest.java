package com.algorithms.searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {

  @Before
  public void setUp() {
    bst = new BST<>();
    bst.put(16, "a");
    bst.put(9, "b");
    bst.put(8, "c");
    bst.put(29, "d");
    bst.put(3, "e");
    bst.put(30, "f");
    bst.put(11, "l");
    bst.put(22,"k");
//    bst.put(6, "g");
//    bst.put(2, "h");
//    bst.put(27,"i");
//    bst.put(24,"j");
//    bst.put(25,"k");
  }

    @Test
  public void postOrderTraversalByStack() throws Exception {
    System.out.print("后序遍历（递归）: ");
    bst.postOrderTraversal();
    System.out.println();
    System.out.print("后序遍历（栈  ）: ");
    bst.postOrderTraversalByStack();
      System.out.println();
  }

  @Test
  public void inOrderTraversalByStack() throws Exception {
    System.out.print("中序遍历（递归）: ");
    bst.inOrderTraversal();
    System.out.println();
    System.out.print("中序遍历（栈  ）: ");
    bst.inOrderTraversalByStack();
  }

  @Test
  public void preOrderTraversalByStack() throws Exception {
    System.out.print("前序遍历（递归）: ");
    bst.preOrderTraversal();
    System.out.println();
    System.out.print("前序遍历（栈  ）: ");
    bst.preOrderTraversalByStack();
  }

  @Test
  public void layerTraver() throws Exception {
    bst.layerTraver();
  }

  @Test
  public void postOrderTraversal() throws Exception {
    bst.postOrderTraversal();
  }

  @Test
  public void inOrderTraversal() throws Exception {
    bst.inOrderTraversal();
  }

  @Test
  public void preOrderTraversal() throws Exception {
    bst.preOrderTraversal();
  }

  @Test
  public void getHeight() throws Exception {
    System.out.println(bst.getHeight());
  }

  @Test
  public void deleteMin() throws Exception {
    bst.deleteMin();
    bst.deleteMin();
  }

  private BST<Integer, String> bst;

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

  @Test
  public void select() throws Exception {
    System.out.println(bst.select(5));
  }

}