package com.yyf.lagou.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序: 将无序数列通过递归的方式进行拆分，再进行合并
 *          在合并的过程中进行排序操作 -> 将两个有序数组和并成一个有序数组
 */
public class Merge {

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr 无序数列
     */
    private static void sort(int[] arr) {
        //创建一个原数组长度的临时数组，防止再递归的过程中频繁创建数组，消耗内存
        int[] tmp = new int[arr.length];
        sort(arr,0,arr.length - 1,tmp);
    }

    private static void sort(int[] arr,int left,int right,int[] tmp){
        if (left < right) {
            int mid = (left + right)/2;
            //左边归并排序，使得左子数列有序
            sort(arr,left,mid,tmp);
            //右边归排序，使得右子数列有序
            sort(arr,mid + 1,right,tmp);
            //合并两个有序数列
            merge(arr,left,mid,right,tmp);
        }
    }

    /**
     * 两个有序子数列合并
     * @param arr 最外面的数组容器
     * @param left 左数列的起始位置
     * @param mid 两个数列的中间位置 左数列的最后一个元素的索引下标
     * @param right 右数列的结束位置
     * @param tmp 用于保存排序结果的数列
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        //左数列的起始位置
        int i = left;
        //右数列的起始位置
        int j = mid + 1;
        //临时数组存储数据的起始位置
        int t = 0;
        //将数据排序存入临时数组中，终止条件有一个子数列遍历结束
        while (i <= mid && j <= right) {
            //较小的元素先存入临时数列中
            //元素存放结束后，临时数列的下标递增，较小元素所在的数列下标递增
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            }else {
                tmp[t++] = arr[j++];
            }
        }
        //左数列和右数列中可能还剩余元素，可以保证剩余的元素都比目前在临时数组中的元素大
        //并且左右数列中只有一个数列中还剩余元素
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        //将临时数组中的数据copy到原数组中
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

}