package com.yyf.lagou.sortalgorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 排序思路：将无序数列调整为大顶堆，将数列开头的元素与末尾元素交换
 *         将数列的末尾元素忽略，忽略后的数列重复上面的步骤
 */
public class Heap {

    public static void main(String[] args) {
        int []arr = {7,6,4,3,5,2,10,9,8,1};
        System.out.println("排序前:"+ Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        //1.把无序数组调整为大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            turnHeap(arr, i, arr.length);
        }
        //2.调整堆结构，交换堆顶元素和末尾元素，调整产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--) {
            //首位元素交换
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            //下沉 调整最大堆
            turnHeap(arr,0, i);
        }
    }

    private static void turnHeap(int[] arr, int p, int length) {
        //parent 用于保存父节点的值
        int parent = arr[p];
        int childIndex = 2 * p + 1;
        while (childIndex < length) {
            //如果存在右节点，定位到右节点
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]){
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if (parent > arr[childIndex]) {
                break;
            }
            //给父节点赋值
            arr[p] = arr[childIndex];
            p = childIndex;
            //下一个左孩子
            childIndex = 2 * p + 1;
        }
        arr[p] = parent;
    }

}
