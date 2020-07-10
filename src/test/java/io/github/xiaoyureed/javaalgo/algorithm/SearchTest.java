package io.github.xiaoyureed.javaalgo.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : xiaoyureed
 * 2020/6/17
 */
public class SearchTest {

    @Test
    @DisplayName("binary search")// 自定义测试用例显示的名称, 默认显示的是方法名
    public void testBinarySearch() {
        int[] arr =  {1, 4, 5, 19, 100};
        Search search = new Search();
        int index = search.binarySearch(arr, 100);
        System.out.println(">>> binary search result: " + index);
    }
}
