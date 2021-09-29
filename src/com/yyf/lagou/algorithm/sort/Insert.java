package com.yyf.lagou.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：
 *      1、直接插入排序
 *          向一个有序数列中插入新的元素，并维护有序性，从而得到一个元素数量+1的有序数列
 *      2、希尔排序
 *          将一个无序数据，按照增量进行分组插入排序，增量每次减少，知道最后增量为1时，
 *          进行最后一次全数列数据直接插入排序
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前：" + Arrays.toString(arr));
        shellSort(arr);
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
     * 元素移动 向右将 start -> end-1 下标所在的元素移动指定步数
     *        操作方式 -> 从后向前处理
     * @param arr 数组
     * @param start 移动元素的起始下标
     * @param end 覆盖终点
     * @param sli 移动步长
     */
    public static void move(int[] arr,int start,int end,int sli) {
        //从后向前开始覆盖数据
        for (int i = end - sli; i >= start  ; i -= sli) {
            arr[i + sli] = arr[i];
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
        move(arr,start,end,1);
    }

    /**
     * 希尔排序
     * @param arr 无序数列
     */
    public static void shellSort(int[] arr) {
        //增量大于1的情况下循环分组插入排序
        //声明第一次循环时使用的增量
        int inc = arr.length / 2;
        while (inc > 0) {
            //遍历待排序的数列 循环终止条件为：数列长度 大于 下标 + 增量
            for (int i = 0; i + inc < arr.length; i++) {
                //跨元素的插入排序
                directSort(arr, i ,inc);
            }
            //计算新的增量
            inc /= 2;
        }
    }

    /**
     * 希尔排序中跨元素的直接插入排序
     * @param arr 无序数列
     * @param start 开始处理的下标
     * @param inc 数据增量
     */
    private static void directSort(int[] arr,int start,int inc) {
        out:
        for (int i = start; i < arr.length; i += inc) {
            //i为有序数列的元素个数数据
            //遍历有序数列
            for (int j = start; j < i; j += inc) {
                //在有序数列中添加元素a
                int a = arr[i];
                if (a < arr[j]) {
                    //向后移动数据
                    move(arr, j, i, inc);
                    arr[j] = a;
                    continue out;
                }
                if (a >= arr[j] && a < arr[j + inc]) {
                    move(arr,j + inc, i, inc);
                    arr[j + inc] = a;
                    continue out;
                }
            }
        }
    }
}


