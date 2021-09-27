package com.yyf.lagou.sortalgorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：
 *      1、直接插入排序
 *          向一个有序数列中插入新的元素，并维护有序性，从而得到一个元素数量+1的有序数列
 *      2、希尔排序
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = new int[]{5,8,6,3,9,2,1,7,4,2,9,0};
        System.out.println("排序前：" + Arrays.toString(arr));
        directSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     *    思路：将无序数列的第一个元素作为一个只有一个元素的有序数列
     *         将后序的元素，添加到前面的有序数列中，最终整个数列排序完成
     * @param arr 无序数列
     */
    private static void directSort(int[] arr) {
        out:
        for (int i = 1; i < arr.length; i++) {
            //i为有序数列的元素个数数据
            //遍历有序数列
            for (int j = 0; j < i; j++) {
                //在有序数列中添加元素a
                int a = arr[i];
                if (a < arr[j]) {
                    move(arr,j, i);
                    arr[j] = a;
                    continue out;
                }
                if (a >= arr[j] && a < arr[j + 1]) {
                    move(arr,j + 1,i);
                    arr[j + 1] = a;
                    continue out;
                }
            }
        }
    }

    /**
     * 元素移动 向右将 start -> end-1 下标所在的元素移动一位
     *        操作方式 -> 从后向前处理
     * @param arr 数组
     * @param start 移动元素的起始下标
     * @param end 覆盖终点
     */
    public static void move(int[] arr,int start,int end) {
        //从后向前开始覆盖数据
        for (int i = end - 1; i >= start  ; i--) {
            arr[i + 1] = arr[i];
        }
    }

    /**
     * 希尔排序
     * @param arr 无序数列
     */
    public static void shellSort(int[] arr) {

    }
}


