package com.algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 基于有序数组的符号表
 *
 * @author XiaoLiang
 * @date 2017/11/8
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

  private Key[] keys;
  private Value[] values;
  private int size;

  public BinarySearchST(int capacity) {
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  private int rank(Key key) {
    int lo = 0;
    int hi = size - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp < 0) {
        hi = mid - 1;
      } else if (cmp > 0) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }

    // 返回的是最近的key的位置
    return lo;
  }

  @Override
  public void put(Key key, Value value) {
    int i = rank(key);

    // 找到key，更新值
    if (i < size && keys[i].compareTo(key) == 0) {
      values[i] = value;
      return;
    }

    // 没有找到key，创建新的元素
    for (int j = size; j > i; j--) {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    keys[i] = key;
    values[i] = value;
    size++;
  }

  @Override
  public Value get(Key key) {
    int i = rank(key);
    if (i < size && keys[i].compareTo(key) == 0) {
      return values[i];
    }
    return null;
  }

  @Override
  public void delete(Key key) {
    int i = rank(key);
    if (i < size && keys[i].compareTo(key) == 0) {
      for (int j = i+1; j < size; j++) {
        keys[j-1] = keys[j];
        values[j-1] = values[j];
      }
      keys[size-1] = null;
      values[size-1] = null;
      size--;
    }
  }

  @Override
  public boolean contains(Key key) {
    int i = rank(key);
    return i < size && keys[i].compareTo(key) == 0;
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
    return Arrays.asList(keys);
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "[empty]";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < size; i++) {
      stringBuilder.append("[").append(keys[i]).append(",").append(values[i]).append("], ");
    }
    return stringBuilder.toString();
  }

  public Key min() {
    if(isEmpty()){
      return null;
    }
    return keys[0];
  }

  public Key max() {
    if(isEmpty()){
      return null;
    }
    return keys[size-1];
  }

  public Key select(int k) {
    if(k >0 && k<size){
      return keys[k];
    }
    return null;
  }
}
