package com.algorithms.searching;

import com.algorithms.stdlib.StdIn;
import com.algorithms.stdlib.StdOut;

/**
 * @author XiaoLiang
 * @date 2017/11/7
 */
public class FrequencyCounter {
  public static void main(String[] args) {
    int minLen = Integer.parseInt(args[0]);
    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
    while (!StdIn.isEmpty()) {
      // 构造符号表并统计
      String word = StdIn.readString();
      if (word.length() < minLen) {
        continue;
      }

      if (!st.contains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }

    // 找出频率最高的词
    String max = "";
    st.put(max, 0);
    for (String word : st.keys()) {
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }

    StdOut.println(max + " " + st.get(max));
  }
}
