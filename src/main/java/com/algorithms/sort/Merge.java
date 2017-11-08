package com.algorithms.sort;

/**
 * 归并排序
 *
 * @author XiaoLiang
 * @date 2016/10/24
 */
public class Merge extends BaseSort {
  /**
   * 辅助数组
   */
  private static Comparable[] aux;

  private static void mergeByInsertion(Comparable[] a, int lo, int mid, int hi) {
    // 插入排序
    for (int i = mid + 1; i <= hi; i++) {
      for (int j = i; j > lo; j--) {
        if (less(a[j], a[j - 1])) {
          exchange(a, j, j - 1);
        } else {
          break;
        }
      }
    }
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  @Override
  public void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }
}
