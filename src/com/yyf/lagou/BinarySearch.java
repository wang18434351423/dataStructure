package com.yyf.lagou;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import com.yyf.test.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 二分法查找
 */
public class BinarySearch {

    public static int func(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        if(nums[l] > target || nums[r] < target){
            return -1;
        }
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static int func1(int[] nums, int target){
        return func2(nums,0,nums.length - 1,target);
    }

    public static int func2(int[] nums, int l, int r, int target){
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return func2(nums,mid + 1,r,target);
        }else {
            return func2(nums,l,mid - 1,target);
        }
    }

    /**
     * 一个有序数组有一个数出现1次，其他数出现2次，
     * 找出出现一次的数比如：1 1 2 2 3 3 4 4 5 5 6 6 7 出现1次的数是7
     */
    public static int func3(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                if(nums[i] < nums[i + 1]){
                    return nums[i];
                }
            }else if(i == nums.length - 1){
                if(nums[i] > nums[i - 1]){
                    return nums[i];
                }
            }else {
                if (nums[i] < nums[i + 1] && nums[i] > nums[i -1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

  /*  public static int func4(int[] nums){
        return func5(nums,0,nums.length);
    }*/
/*
    public static int func5(int[] nums,int l,int r){
        if(l > r) return -1;
        int mid = (l + r) / 2;
        if(mid == 0 && nums[mid] < nums[mid + 1]){
            return nums[mid];
        }else if (mid == nums.length - 1 && nums[mid] >nums[mid -1]){
            return nums[mid];
        }else if(nums[mid] > nums[mid - 1] &&  nums[mid] < nums[mid + 1]){
            return nums[mid];
        }
        if()
    }*/

    public static void main(String[] args) {

        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime minus = localDateTime.minus(12, ChronoUnit.HOURS);
        Date date = Date.from( minus.atZone( ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }

}
