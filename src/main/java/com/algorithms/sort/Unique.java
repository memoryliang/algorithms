package com.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 数组计数
 *
 * @author XiaoLiang
 * @date 2017/11/13
 */
public class Unique {
  public static void count_1(int[] arr) {
    Arrays.sort(arr);
    int left = 0, right;
    while (left < arr.length) {
      for (right = left; right < arr.length; right++) {
        if (arr[left] != arr[right]) {
          break;
        }
      }
      System.out.println(arr[left] + ": " + (right - left));
      left = right;
    }
  }

  public static void count_2(int[] arr) {
    Arrays.sort(arr);
    int right = 0;
    for (int left = 0; left < arr.length; left = right) {
      for (right = left + 1; right < arr.length; right++) {
        if (arr[left] != arr[right]) {
          break;
        }
      }
    }
  }

  public static void count_3(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    Arrays.sort(arr);
    int left;
    int right;
    for (left = 0, right = 0; right < arr.length; right++) {
      if (arr[left] != arr[right]) {
        System.out.println(arr[left] + ": " + (right - left));
        left = right;
      }
    }
    System.out.println(arr[left] + ": " + (right - left));
  }

  public static void main(String[] args) {
    count_2(new int[]{1, 3, 2, 7, 9, 2, 7, 9, 2});
  }
}
