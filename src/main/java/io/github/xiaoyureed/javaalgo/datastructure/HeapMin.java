package io.github.xiaoyureed.javaalgo.datastructure;

/**
 * @author : xiaoyureed
 * 2020/7/11
 */
public class HeapMin {
    private int[] store;

    /**
     * 空穴上滤
     *
     * 空穴的p_node vs. 待添加node, 若 parent node 小于 to add node, 将 parent node 值赋值给 空穴节点, 使得 parent node 成为
     * 新的 空节点, 循环比较, 知道 parent node 值 <= to add node 或者 空节点成为 root 节点, 就将 to add node 赋值给 这个空节点
     *
     * while null_node.p_node > to_add_node then
     *      swap(p_node, null_node)
     */
    public void put(int ele) {

    }

    /**
     * 空穴下滤
     */
    public int deleteMin() {
        return 0;
    }
}

class HeapMax {

}
