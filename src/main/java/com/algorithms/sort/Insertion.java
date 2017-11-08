package com.algorithms.sort;

/**
 * 插入排序
 *
 * @author XiaoLiang
 * @date 2016/10/20
 */
public class Insertion extends BaseSort {

  @Override
  public void sort(Comparable[] a) {
    int length = a.length;
    for (int i = 1; i < length; i++) {
      for (int j = i; j > 0; j--) {
        if (less(a[j], a[j - 1])) {
          exchange(a, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
