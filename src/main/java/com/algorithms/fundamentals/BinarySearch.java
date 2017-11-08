package com.algorithms.fundamentals;

/**
 * 二分查找
 *
 * @author XiaoLiang
 * @date 2017/11/7
 */
public class BinarySearch {
  private int[] a;

  public BinarySearch(int[] a) {
    this.a = a;
  }

  public int indexOf(int key) {
    int lo = 0;
    int hi = a.length - 1;
//    return rank(key, lo, hi);
    return rankByRecursive(key, lo, hi);
  }

  private int rank(int key, int lo, int hi) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (a[mid] < key) {
        lo = mid + 1;
      } else if (a[mid] > key) {
        hi = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  private int rankByRecursive(int key, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (a[mid] < key) {
      return rankByRecursive(key, mid + 1, hi);
    } else if (a[mid] > key) {
      return rankByRecursive(key, lo, mid - 1);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    BinarySearch binarySearch = new BinarySearch(a);
    System.out.println(binarySearch.indexOf(1));
    System.out.println(binarySearch.indexOf(10));
    System.out.println(binarySearch.indexOf(3));
    System.out.println(binarySearch.indexOf(6));
    System.out.println(binarySearch.indexOf(12));
  }
}
