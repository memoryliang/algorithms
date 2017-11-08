package com.algorithms.searching;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 基于无序链表的符号表
 *
 * @author XiaoLiang
 * @date 2017/11/7
 */
public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value> {

  private Node first;
  private int size;

  @Override
  public void put(Key key, Value value) {
    for (Node node = first; node != null; node = node.next){
      if(key.equals(node.key)){
        node.value = value;
        return;
      }
    }

    first = new Node(key, value, first);
    size++;
  }

  @Override
  public Value get(Key key) {
    for (Node node = first; node != null; node = node.next) {
      if (key.equals(node.key)) {
        return node.value;
      }
    }
    return null;
  }

  @Override
  public void delete(Key key) {
    Node prev = null;
    for(Node node = first; node != null; node = node.next) {
      if(key.equals(node.key)){
        if(prev == null){
          first = node.next;
        }else {
          prev.next = node.next;
        }
        size--;
        // clear GC
        node.key = null;
        node.value = null;
        return;
      }
      prev = node;
    }
  }

  @Override
  public boolean contains(Key key) {
    for(Node node = first; node != null; node = node.next){
      if(key.equals(node.key)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterable<Key> keys() {
    ArrayList<Key> list = new ArrayList<>(size);
    for(Node node = first; node != null; node = node.next){
      list.add(node.key);
    }
    return list;
  }

  private class Node {
    private Key key;
    private Value value;
    private Node next;

    Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
}
