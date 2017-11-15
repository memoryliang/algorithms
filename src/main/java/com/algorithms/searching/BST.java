package com.algorithms.searching;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉查找树
 *
 * @author XiaoLiang
 * @date 2017/11/8
 */
public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
  private Node root;

  @Override
  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value, 1);
    }
    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    node.length = size(node.left) + size(node.right) + 1;
    return node;
  }

  @Override
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      return get(node.left, key);
    } else if (cmp > 0) {
      return get(node.right, key);
    } else {
      return node.value;
    }
  }

  @Override
  public void delete(Key key) {

  }

  @Override
  public boolean contains(Key key) {
    return get(root, key) != null;
  }

  public Key select(int k) {
    return root == null ? null : select(root, k).key;
  }

  private Node select(Node node, int k) {
    if (node == null) {
      return null;
    }

    int t = size(node.left);
    if (t > k) {
      return select(node.left, k);
    } else if (t < k) {
      return select(node.right, k - t - 1);
    } else {
      return node;
    }
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  /**
   * 树的高度
   *
   * @return 高度
   */
  public int getHeight() {
    return getHeight(root);
  }

  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
  }

  private Node deleteMin(Node node) {
    if (node == null) {
      return null;
    }

    if (node.left == null) {
      return node.right;
    }

    node.left = deleteMin(node.left);
    node.length = size(node.left) + size(node.right) + 1;
    return node;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) {
      return 0;
    } else {
      return node.length;
    }
  }

  public Key min() {
    return root == null ? null : min(root).key;
  }

  private Node min(Node node) {
    if (node == null || node.left == null) {
      return node;
    }

    return min(node.left);
  }

  public Key max() {
    return root == null ? null : max(root).key;
  }

  private Node max(Node node) {
    if (node == null || node.right == null) {
      return node;
    }
    return max(node.right);
  }

  /**
   * 小于等于key的最大键
   *
   * @param key key
   * @return 小于等于key的最大键
   */
  public Key floor(Key key) {
    throw new NotImplementedException();
  }

  /**
   * 深度优先遍历--前序遍历
   */
  public void preOrderTraversal() {
    if (root == null) {
      return;
    }
    preOrderTraversal(root);
  }

  private void preOrderTraversal(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node+"->");

    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }

  /**
   * 深度优先遍历--前序遍历, 非递归实现
   */
  public void preOrderTraversalByStack() {
    if (root == null) {
      return;
    }
    preOrderTraversalByStack(root);
  }

  private void preOrderTraversalByStack(Node node) {
    if (node == null) {
      return;
    }

    LinkedList<Node> stack = new LinkedList<>();
    while (node != null || !stack.isEmpty()){
      while (node!=null) {
        System.out.print(node +"->");
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      node = node.right;
    }
  }

  /**
   * 深度优先遍历--中序遍历
   */
  public void inOrderTraversal() {
    if (root == null) {
      return;
    }
    inOrderTraversal(root);
  }

  private void inOrderTraversal(Node node) {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.left);
    System.out.print(node+"->");
    inOrderTraversal(node.right);
  }

  /**
   * 深度优先遍历--中序遍历, 基于栈实现
   */
  public void inOrderTraversalByStack() {
    if (root == null) {
      return;
    }
    inOrderTraversalByStack(root);
  }

  private void inOrderTraversalByStack(Node node) {
    if(node == null) {
      return;
    }
    LinkedList<Node> stack = new LinkedList<>();
    while (node!=null || !stack.isEmpty()){
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      System.out.print(node+"->");
      node = node.right;
    }
  }

  /**
   * 深度优先遍历--后序遍历
   */
  public void postOrderTraversal() {
    if (root == null) {
      return;
    }
    postOrderTraversal(root);
  }

  private void postOrderTraversal(Node node) {
    if (node == null) {
      return;
    }

    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    System.out.print(node+"->");
  }

  /**
   * 深度优先遍历--后序遍历, 基于栈
   */
  public void postOrderTraversalByStack() {
    if (root == null) {
      return;
    }
    postOrderTraversalByStack(root);
  }

  private void postOrderTraversalByStack(Node node) {
    if(node == null) {
      return;
    }
    LinkedList<Node> stack = new LinkedList<>();
    Set<Node> nodeSet = new HashSet<>();
    while (node != null || !stack.isEmpty()){
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.peek();
      if(node.right == null || nodeSet.contains(node)) {
        node = stack.pop();
        System.out.print(node +"->");

        if(nodeSet.contains(node)){
          nodeSet.remove(node);
          node = null;
        }

      }else {
        nodeSet.add(node);
      }

      if(node != null) {
        node = node.right;
      }
    }

  }

  /**
   * 广度优先遍历
   */
  public void layerTraver() {
    if (root == null) {
      return;
    }

    layerTraver(root);
  }

  private void layerTraver(Node node) {
    if (node == null) {
      return;
    }

    return;
  }

  @Override
  public Iterable<Key> keys() {
    return null;
  }

  private class Node {
    private Key key;
    private Value value;
    private Node left, right;
    /**
     * 以该节点为根的子树中节点的总数
     */
    private int length;

    public Node(Key key, Value value, int length) {
      this.key = key;
      this.value = value;
      this.length = length;
    }

    @Override
    public String toString() {
      return "{" + key + ", " + value + '}';
    }
  }
}
