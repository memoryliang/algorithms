package com.algorithms.sort;

import java.util.Date;

/**
 * 排序基类
 * @author XiaoLiang
 * @date 2016/10/20
 */
public abstract class BaseSort {

  /**
   * 排序方法
   * @param a 数组
   */
  public abstract void sort(Comparable[] a);

  protected static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  protected static void exchange(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /**
   * 测试数组元素是否排序   *
   * @param a 数组
   * @return 已经排序返回true,否则返回flase
   */
  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i--])) {
        return false;
      }
    }
    return true;
  }

  protected static void show(Comparable[] a) {
    for (Comparable comparable : a) {
      System.out.print(comparable + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Date date = new Date();
    System.out.println(date.getTime());
    Integer[] a = {7, 0,0,0,1, 9, 1, 3,3,2,2,2,22,6,2,3, 5, 8,2, 11, 2, 5,2, 6, 22, 7, 8, 2,22, 34, 1, 11, 2, 12, 16,2, 55, 75, 37, 10, 123, 0};
    BaseSort baseSort = new Shell();
    baseSort.sort(a);
//    int max = 1;
//
//    int count = 1;
//    for (int i = 1; i < a.length; i++) {
//      if(a[i].compareTo(a[i-1])!=0){
//        if(count>max){
//          max = count;
//        }
//        count = 1;
//      }else {
//        count++;
//      }
//    }
//    System.out.println(max);
    show(a);
  }
}
