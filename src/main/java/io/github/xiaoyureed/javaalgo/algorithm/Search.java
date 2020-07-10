package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * 搜索算法
 */
public class Search {
    /**
     * 二分查找
     */
    public int binarySearch(int[] arr, int target) {

        for (int pivot = arr.length / 2; pivot > 0; pivot = pivot / 2) {
            if (arr[pivot] == target) {
                return pivot;
            }
        }
        return -1;
    }
}
