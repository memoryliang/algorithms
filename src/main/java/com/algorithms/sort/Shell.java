package com.algorithms.sort;

import java.util.Arrays;

/**
 * shell排序
 *
 * @author XiaoLiang
 * @date 2016/10/27
 */
public class Shell extends BaseSort {
  @Override
  public void sort(Comparable[] a) {
    int length = a.length;
    int n = 1;
    while (n < length / 3) {
      n = 3 * n + 1;
    }

    while (n >= 1) {
      // 插入排序
      for (int i = n; i < length; i += n) {
        for (int j = i; j >= n; j -= n) {
          if (less(a[j], a[j - n])) {
            exchange(a, j, j - n);
          } else {
            break;
          }
        }
      }

      n = n / 3;
    }
  }
}
