package com.yyf.lagou.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Quick {

    public static void main(String[] args) {
        int[] arr = {3,1,4,8,2,5,9,6,7};
        oneSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 双边循环法
     */
    public static void doubleSort(int[] arr, int start, int end){
        //递归结束条件
        if (start >= end) {
            return;
        }
        //获取基准元素
        int pivotIndex = doublePartition(arr,start,end);
        //根据基准元素，分成两部分进行处理
        doubleSort(arr,start,pivotIndex - 1);
        doubleSort(arr,pivotIndex + 1,end);
    }

    /**
     * 分治（双边循环法）
     * @param arr 待交换的数组
     * @param start 起始下标
     * @param end 结束下标
     * @return
     */
    private static int doublePartition(int[] arr, int start, int end) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left != right){
            //控制right 指针比较并左移
            while (left < right && arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot){
                left++;
            }
            //大小元素位置交换
            if (left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        //pivot 和 指针重合点交换
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 单边循环法
     */
    public static void oneSort(int[] arr,int start,int end) {
        if (start >= end) return;
        //获取基准点下标
        int pivot = onePartition(arr,start,end);
        oneSort(arr,start,pivot -1);
        oneSort(arr,pivot+1,end);
    }

    /**
     * 分治（单边循环法）
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int onePartition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int mark = start;
        for (int i = start; i <= end; i++) {
            //如果遇到小于指标的元素，小于区域扩大一位
            if (arr[i] < pivot && mark < end){
                mark++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        //此时start - mark所在下标数据都小于 pivot
        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
