package com.yyf.lagou.other;


import java.util.Arrays;
import java.util.List;

/**
 * 二分法查找
 */
public class BinarySearch {

    /**
     * 双指针查找
     * @param nums 有序数组
     * @param target 目标值
     * @return 目标值下标 不存在为-1
     */
    public static int func(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找递归实现
     * @param nums 有序数组
     * @param target 目标值
     * @return 目标值下标 不存在为-1
     */
    public static int func1(int[] nums,int target){
        return func2(nums,target,0,nums.length - 1);
    }

    /**
     * - 函数的功能：在有序数组查找目标值的下标
     * - 递归结束条件：左指针大于右指针时结束或找到相等的值结束
     * - 函数的等价关系式：fun(nums[],target,left,right) = fun(nums[],target,mid + 1,right) or fun(nums[],target,left,mid - 1)
     */
    private static int func2(int[] nums, int target, int left, int right) {
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if(nums[mid] < target) left = mid + 1;
        else right = mid - 1;
        return func2(nums,target,left,right);
    }

    /**
     * 案例
     * 一个有序数组有一个数出现1次，其他数出现2次，
     * 找出出现一次的数比如：
     * 1 1 2 2 3 3 4 4 5 5 6 6 7 出现1次的数是7
     * 1 1 2 3 3 4 4 5 5 6 6 7 7 出现1次的数是2
     * 0 1 2 3 4 5 6 7 8 9 10 11 12
     */
    private static int func3(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(mid % 2 == 0){//如果是偶数
                if (nums[mid] == nums[mid - 1]){
                    //如果和前面相同,说明右边正确
                    right = mid - 2;
                }else {
                    //和前面不同说明左边正确
                    if(nums[mid] != nums[mid + 1]){
                        return mid;
                    }else {
                        left = mid + 2;
                    }
                }
            }else {//如果是奇数

            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "北京市";
        String[] split = str.split("1");
        int length = split.length;
        System.out.println(Arrays.toString(split)+"   1   "+length);
    }

}
