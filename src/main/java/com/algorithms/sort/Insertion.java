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
    commonSort(a);
  }

  /**
   * 普通插入排序
   * @param a 待排序数组
   */
  private void commonSort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0; j--) {
        if (less(a[j], a[j - 1])) {
          exchange(a, j, j - 1);
        } else {
          break;
        }
      }
    }
  }

  /**
   * 基于二分查找的插入排序
   *
   * @param a 待排序数组
   */
  private void sortByBinarySearch(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i].compareTo(a[i - 1]) > 0) {
        continue;
      }
      int position = this.binarySearch(a, a[i], 0, i - 1);
      Comparable key = a[i];
      for (int j = i; j > position; j--) {
        a[j] = a[j - 1];
      }
      a[position] = key;
    }
  }

  /**
   * 二分查找
   *
   * @param a   集合
   * @param key 要查找的元素
   * @param lo  集合的左边界
   * @param hi  集合的右边界
   * @return 返回key的位置，如果不存在，则返回key左边最近的元素
   */
  private int binarySearch(Comparable[] a, Comparable key, int lo, int hi) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = key.compareTo(a[mid]);
      if (cmp < 0) {
        hi = mid - 1;
      } else if (cmp == 0) {
        return mid;
      } else if (cmp > 0) {
        lo = mid + 1;
      }
    }
    return lo;
  }
}
