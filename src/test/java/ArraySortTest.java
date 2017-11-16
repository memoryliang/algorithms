import java.util.Arrays;
import java.util.Random;

/**
 * 数组归并排序
 */
public class ArraySortTest {
  private static int[] intArr;
  private static int[] auxArr; //辅助数组
  private static int[] arr; // 用于Arrays默认排序
  private static int[] lambdaArr; //并行排序

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int length = 100000000;
    intArr = new int[length];
    auxArr = new int[length];
    arr = new int[length];
    lambdaArr = new int[length];

    Random random = new Random();
    int temp;
    for (int i = 0; i < length; i++) {
      temp = random.nextInt(length * 5);
      intArr[i] = temp;
      arr[i] = temp;
      lambdaArr[i] = temp;
    }

    // 归并排序
    long sortStart = System.currentTimeMillis();
    sort(0, intArr.length - 1);
    long sortEnd = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    System.out.println("      归并排序时间: " + (sortEnd - sortStart) / (1000.0) + "秒");

    // Arrays自带排序
    sortStart = System.currentTimeMillis();
    Arrays.sort(arr);
    sortEnd = System.currentTimeMillis();
    end = System.currentTimeMillis();
    System.out.println(" Array默认排序时间: " + (sortEnd - sortStart) / (1000.0) + "秒");

    // lambda并行排序
    sortStart = System.currentTimeMillis();
    Arrays.stream(lambdaArr).parallel().sorted().toArray();
    sortEnd = System.currentTimeMillis();
    end = System.currentTimeMillis();
    System.out.println("Lambda并行排序时间: " + (sortEnd - sortStart) / (1000.0) + "秒");

    System.out.println("      系统运行时间: " + (end - start) / 1000.0 + "秒");
  }

  public static void merge(int lo, int mid, int hi) {
//    for (int i = lo; i <= hi; i++) {
//      auxArr[i] = intArr[i];
//    }
    System.arraycopy(intArr, lo, auxArr, lo, (hi - lo + 1));
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        intArr[k] = auxArr[j++];
      } else if (j > hi) {
        intArr[k] = auxArr[i++];
      } else if (auxArr[i] < intArr[j]) {
        intArr[k] = auxArr[i++];
      } else {
        intArr[k] = auxArr[j++];
      }
    }
  }

  public static void sort(int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(lo, mid);
    sort(mid + 1, hi);
    merge(lo, mid, hi);
  }
}
