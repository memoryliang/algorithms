package com.algorithms.sort;

/**
 * 选择排序
 * 1: 找到数组中最小的那个元素
 * 2: 将它和数组中的第一个元素交换位置
 * 3: 在剩下的元素中找到最小的元素，将它与数组中的第二个元素交换。依次类推，直至将数组中的所有元素排序
 * @author XiaoLiang
 * @date 2016/11/2
 */
public class Selection extends BaseSort {
  @Override
  public void sort(Comparable[] a) {
    int length = a.length;
    for (int i = 0; i < a.length; i++) {
      int min = i;
      for (int j = i; j < a.length; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exchange(a, i, min);
    }
  }
}
