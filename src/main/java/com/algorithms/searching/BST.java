package com.algorithms.searching;

import com.sun.org.apache.regexp.internal.RE;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
  }
}
