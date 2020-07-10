package io.github.xiaoyureed.javaalgo.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : xiaoyureed
 * 2020/6/18
 */
public class SortTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {222, 10, 99, 100, 23, -1};
        new Sort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
