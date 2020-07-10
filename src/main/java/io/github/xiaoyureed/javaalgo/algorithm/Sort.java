package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * 排序算法
 *
 * @author : xiaoyureed
 * 2020/6/17
 */
public class Sort {

    /**
     * bubble sort
     *
     * O(n^2)
     */
    public void bubbleSort(int[] arr) {
        if (arr == null) return;

        // 外层循环从头到尾
        for (int i = 0; i < arr.length; i++) {
            // 内存循环从末尾开始, 每次比较相邻的两个数, 小的往前浮动
            // 也可以从头开始, 大的往后浮动
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 选择排序, 比之冒泡排序, 时间复杂度差不多, 但是位置交换大大减少
     *
     * O(n^2)
     */
    public void selectSort(int[] arr) {
        if(arr == null) return;

        // 外层循环从头到尾, 每选择一个数, 都在内层循环跟剩余的数依次比较, 将小的数交换到外层循环当前选定的位置
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; // 内层循环中, 最小数的下标

            // 内层循环负责找到余下最小的数的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * 插入排序
     *
     * O(n^2)
     */
    public void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }

        //i控制循环次数，因为已经默认第一个数的位置是正确的，所以i的起始值为1，i<len，循环len-1次
        for (int i = 1; i < arr.length; i++) {
            int j = i; // 待插入的元素位置
            int target = arr[j]; // 待插入元素值
            while (j > 0 && target < arr[j - 1]) {
                arr[j]  = arr[j - 1];
                j--;
            }
            arr[j]=target;
        }
    }

    /**
     * 交换位置
     */
    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
