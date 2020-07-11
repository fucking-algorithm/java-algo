package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * 排序算法
 * https://juejin.im/post/5c40837751882525487c5394
 *
 * @author : xiaoyureed
 * 2020/6/17
 */
public class Sort {

    /**
     * 快速排序
     * 1. 找一个基准数（一般将待排序的数组的第一个数作为基准数）
     * 2. 对数组进行分区，将小于等于基准数的全部放在左边，大于基准数的全部放在右边。
     * 3. 重复1，2步骤，分别对左右两个子分区进行分区，一直到各分区只有一个数为止。
     *
     * O(n log n)
     *
     * 不稳定 (排序算法的稳定性: 排序前后多个相等值的元素相对位置是否变化)
     */
    public void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {

        }

    }

    private void quickSortRecur(int[] arr, int left, int right) {

    }



    /**
     * 归并排序
     *
     * O(n log n)
     */

    /**
     * bubble sort
     *
     * 依次比较相邻的两个元素
     * <p>
     * O(n^2)
     *
     * 稳定
     */
    public void bubbleSort(int[] arr) {
        if (arr == null) return;

        // 外层循环从头到尾, 控制总共循环多少次
        for (int end = arr.length - 1; end > 0; end--) {
            // 内存循环从末尾开始, 每次比较相邻的两个数, 小的往前浮动
            // 也可以从头开始, 大的往后浮动
            for (int start = 1; start <= end; start++) {
                if (arr[start] < arr[start - 1]) {// 无序, 需要交换
                    swap(arr, start, start - 1);
                }
            }
        }
    }

    /**
     * 优化 1: 如果 arr 完全有序, 那么 可以提前返回
     */
    public void bubbleSortOptimized1(int[] arr) {
        if (arr == null) return;

        // 外层循环从头到尾, 控制总共循环多少次
        for (int end = arr.length - 1; end > 0; end--) {
            boolean isSorted = true; // 假设数组完全有序

            // 内存循环从末尾开始, 每次比较相邻的两个数, 小的往前浮动
            // 也可以从头开始, 大的往后浮动
            for (int start = 1; start <= end; start++) {
                if (arr[start] < arr[start - 1]) {// 无序, 需要交换
                    swap(arr, start, start - 1);
                    isSorted = false; // 发生了交换, 证明该数组无序
                }
            }
            // 一轮比较完成, 如果没有发生任何交换, 证明数组本来有序, 返回
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 优化 2: 如果 arr 部分有序, 那么记录当前这轮循环最后发生元素交换的下标
     * 在下一轮循环中排除掉有序的部分
     */
    public void bubbleSortOptimized2(int[] arr) {
        if (arr == null) return;

        // 外层循环从头到尾, 控制总共循环多少次
        for (int end = arr.length - 1; end > 0; end--) {
            int lastSwapIndex = end;// 初始值假设为 end, 意味着数组完全有序

            // 内存循环从末尾开始, 每次比较相邻的两个数, 小的往前浮动
            // 也可以从头开始, 大的往后浮动
            for (int start = 1; start <= end; start++) {
                if (arr[start] < arr[start - 1]) {// 无序, 需要交换
                    swap(arr, start, start - 1);
                    lastSwapIndex = start;
                }
            }
            end = lastSwapIndex;
        }
    }

    /**
     * 插入排序
     * <p>
     * O(n^2)
     */
    public void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }

        //i控制循环次数，因为已经默认第一个数的位置是正确的，所以i的起始值为1，i<len，循环len-1次
        for (int i = 1; i < arr.length; i++) {
            int j = i; // 待插入的元素位置
            int target = arr[j]; // 插入元素值
            while (j > 0 && target < arr[j - 1]) {
                arr[j]  = arr[j - 1];
                j--;
            }
            arr[j]=target;
        }
    }

    /**
     * 堆排序: 实际就是对选择排序的优化, 在内层循环中 (也就是找最值) 使用了堆结构
     *
     * O(n log n)
     */
    public void heapSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                
            }
        }
    }

    ///////////////////////////////////////////////////////////////////

    /**
     * 选择排序: 找出最大的元素, 和末尾元素交换位置
     * 比之冒泡排序, 时间复杂度差不多, 但是位置交换大大减少
     * <p>
     * O(n^2)
     *
     * 不稳定
     *
     * 优化: 内存循环就是找最值, 可以使用堆
     */
    public void selectionSort(int[] arr) {
        if (arr == null) return;

        for (int i = arr.length - 1; i > 0; i--) {
            int indexMax = i; // 假设末尾就是最大值
            for (int j = 0; j <= i; j++) {
                // 带上等号, 是为了排序的稳定, 算法是将最大值交换到末尾, 所以即使相等, 也要讲当前元素位置赋值给 indexMax
                // !!!: 即使带上等号, 选择排序也是不稳定的, 考虑这个序列: 7 5 10 10 2 4 2
                // 扫描到第二个 10, 会和末尾的 2 交换, 那么 两个 2 的相对位置就变化了, 所以 selectionSort 不是稳定的
                if (arr[j] >= arr[indexMax]) {
                    indexMax = j;
                }
            }
            if (indexMax != i) {
                swap(arr, indexMax, i);
            }
        }
    }



    /**
     * 桶排序
     *
     * O(n + k)
     */

    /**
     * 交换位置
     */
    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
