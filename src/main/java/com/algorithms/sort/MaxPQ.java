package com.algorithms.sort;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;

/**
 * 基于数组的优先队列
 * @author XiaoLiang
 * @date 2017/7/3
 */
public class MaxPQ<Key extends Comparable<Key>> {
  /**
   * 基于堆的完全二叉树
   */
  private Key[] pq;

  /**
   * 存储于pa[1...N ]中， pq[0]没有使用
   */
  private int N = 0;

  public MaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN+1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public  void insert(Key v){
    pq[++N] = v;
    swim(N);
  }

  public Key delMax() {
    throw new NotImplementedException();
  }

  private void swim(int k){
    while (k>1 && less(k/2, k)){
      exch(k/2, k);
      k = k/2;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < N; i++) {
      sb.append(pq[i]).append(", ");
    }
    sb.append(pq[N]);
    return sb.toString();
  }

  private boolean less(int i, int j){
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j){
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  public static void main(String[] args) {
    MaxPQ<Integer> pq = new MaxPQ<>(20);
    pq.insert(5);
    pq.insert(8);
    pq.insert(1);
    pq.insert(2);
    pq.insert(8);
    pq.insert(12);
    pq.insert(7);
    pq.insert(10);
    pq.insert(22);
    pq.insert(15);
    System.out.println(pq.toString());
  }
}
