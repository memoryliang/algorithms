package com.algorithms.searching;

/**
 * 符号表操作接口
 * @author XiaoLiang
 * @date 2017/11/7
 */
public interface SymbolTable<Key, Value> {
  /**
   * 将键值存入符号表中
   * @param key key
   * @param value value
   */
  void put(Key key, Value value);

  /**
   * 获取key对应的值
   * @param key key
   * @return key不存在，返回null
   */
  Value get(Key key);

  /**
   * 即时删除指定的key以及值
   * @param key key
   */
  void delete(Key key);

  /**
   * 键key在表中是否存在对应的值
   * @param key key
   * @return 存在返回true，否则返回false
   */
  boolean contains(Key key);

  /**
   * 表是否为空
   * @return 表为空返回true，否则返回false
   */
  boolean isEmpty();

  /**
   * 表中键值对的数量
   * @return 数量
   */
  int size();

  /**
   * 表中所有key的集合
   * @return key集合
   */
  Iterable<Key> keys();
}
