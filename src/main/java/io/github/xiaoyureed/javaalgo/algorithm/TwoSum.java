package io.github.xiaoyureed.javaalgo.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定数组 arr, 值 target, 返回 两个下标, 使得对应值之和为 target
 *
 * @author : xiaoyureed
 * 2020/7/12
 */
public class TwoSum {

    /**
     * 暴力循环
     *
     * O(n^2)
     */
    int[] twoSum1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 使用 哈希表
     * 
     * 空间换时间, 哈希表查找元素时间复杂度 O(1)
     */
    int[] twoSum2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            // !!!: 这里 key 为元素, value 为数组下标, 因为后面比较时, 需要根据值获取下标来证
            //明数组中的值和 map 中的值不是同一个值
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int other = target - arr[i];
            if (map.containsKey(other)
                    && map.get(other) != i) {
                return new int[] {i, map.get(arr[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
