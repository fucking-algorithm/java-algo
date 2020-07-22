package io.github.xiaoyureed.javaalgo.datastructure;

import java.lang.reflect.Array;

/**
 * 数组实现队列
 *
 * @author : xiaoyureed
 * 2020/7/22
 */
public class ArrayQueue1<T> {

    private T[] data;
    private int count;

    public ArrayQueue1(Class<T> clazz, int size) {
        Object newInstance = Array.newInstance(clazz, size);
        data = (T[]) newInstance;
        count = 0;
    }

    public T deQueue() {
        T ret = data[0];
        data[0] = null;
        for (int i = 0; i < count; i++) {// 顺次向前挪动
            data[i] = data[i+1];
        }
        count = count -1;
        return ret;
    }

    public void enQueue(T value) {
        data[count] = value;
        count = count + 1;
    }

    public T top() {
        return data[0];
    }

    public boolean empty() {
        if (count == 0) {
            return true;
        }
        if (count < 0) {
            throw new RuntimeException("count < 0");
        }
        return false;
    }
}