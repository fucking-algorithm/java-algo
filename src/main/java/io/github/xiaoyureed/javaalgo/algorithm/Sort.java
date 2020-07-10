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
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public void selectSort(int[] arr) {

    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
