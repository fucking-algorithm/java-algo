package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * 搜索算法
 */
public class Search {
    /**
     * 二分查找: 使用双指针
     *
     * 数组必须有序
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // 为什么不直接 (left + right) / 2 呢
            // 防止 left + right 结果太大, 造成溢出错误
            int mid = left + (right -left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
