package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * 排序算法
 * https://juejin.im/post/5c40837751882525487c5394
 * https://www.cnblogs.com/wxisme/p/5243631.html
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
        quickSortRecur(arr, left, right);
    }

    private void quickSortRecur(int[] arr, int left, int right) {
        if (left >= right) return;

        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        int pIndex =index - 1;


        quickSortRecur(arr, left, pIndex - 1);
        quickSortRecur(arr, pIndex + 1, right);
    }

    /**
     * 快速排序 写法二
     *
     * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)
     *
     * 选择一个基准数 比如arr[0]， 有两个指针， 右指针找比基准数小的，左指针找比基准数大的，交换之，
     * 也就是将比 基准数小的移动到 其左边， 比基准数大的移动到右边，然后以基准数为界，分为两部分
     * 分而治之 （递归）
     *
     * 如： 对5,3,8,6,4这个无序序列进行快速排序
     * 5,3,8,6,4 用5作为比较的基准，最终会把5小的移动到5的左边，比5大的移动到5的右边。
     * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描（思考一下为什么？）4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
     * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
     * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
     *
     * @author xiaoyu
     * Date 2020-6-16
     */
    void sort2_1(int[] arr, int left, int right) {

        if (left >= right) return;

        int i, j, partitionIndex;
        partitionIndex = left;
        i = left;
        j = right;

        while (i < j) {
            // 从后往前检索比 partitionIndex 小的值
            while (arr[j] >= arr[partitionIndex] && i < j) j--;
            // 从前往后检索比 partitionIndex 大的值
            while (arr[i] <= arr[partitionIndex] && i < j) i++;
            // 交换
            swap(arr, i, j);
        }
        swap(arr, left, j);
        sort2_1(arr, left, right - 1);
        sort2_1(arr, left + 1, right);

    }



    /**
     * 归并排序
     *
     * O(n log n)
     */



    /**
     * bubble sort 冒泡排序: 依次比较相邻的两个元素, 将较大的数后移
     *
     * 第一次扫描, 从 0 ~ arr.leng - 1, 最大值到达末尾
     * 第二次扫描 , 0 ~ arr.length - 2, 剩下的数中最大值到达末尾
     * ...
     *
     * <p>
     * O(n^2)
     *
     * 稳定
     */
    public void bubbleSort(int[] arr) {
        if (arr == null) return;

        // 外层循环尾到头, 控制总共循环多少次
        for (int end = arr.length - 1; end > 0; end--) {
            // 内层循环从头开始, 每次比较相邻的两个数, 大的往后浮动
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

        for (int end = arr.length - 1; end > 0; end--) {
            boolean isSorted = true; // 假设数组完全有序

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

        for (int end = arr.length - 1; end > 0; end--) {
            int lastSwapIndex = end;// 初始值假设为 end, 意味着数组完全有序

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
     * 比之冒泡排序, 时间复杂度差不多, 但是位置交换次数大大减少
     * <p>
     * O(n^2)
     *
     * 不稳定
     *
     * 优化: 内存循环就是找最值, 可以使用堆, 见堆排序
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
