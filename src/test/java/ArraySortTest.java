import com.algorithms.sort.*;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组默认排序方法测试
 */
public class ArraySortTest {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int[] intArr = new int[1000000000];
    Random random = new Random();
    for (int i = 0; i < intArr.length; i++) {
      intArr[i] = random.nextInt(900000000);
    }
    long sortStart = System.currentTimeMillis();
    Arrays.sort(intArr);
    long sortEnd = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    System.out.println("排序时间： " + (sortEnd-sortStart)/(1000.0));
    System.out.println("系统运行时间: " + (end-start)/1000.0);
  }
}
