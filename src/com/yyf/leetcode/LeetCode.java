package com.yyf.leetcode;

import java.util.*;

public class LeetCode {


    public static int reverse(int x) {
        Long result = 0L;
        while (x != 0){
            result = result * 10;
            result = result +  x % 10;
            x = x / 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : result.intValue();
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        boolean result = false;
        String val = String.valueOf(x);
        for (int i = 0 , j = val.length() - 1; i < val.length(); i++,j--) {
            char c = val.charAt(i);
            char c1 = val.charAt(j);
            if(c != c1){
                result = false;
                break;
            }else {
                if(i >= j){
                    result = true;
                }
            }
        }
        return result;
    }



    /**
     * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     *
     * 字符          数值
     * I             1
     * V             5    5
     * X             10   2
     * L             50   5
     * C             100  2
     * D             500  5
     * M             1000 2
     * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     *
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
     *
     * 示例1:
     *
     * 输入:"III"
     * 输出: 3
     * 示例2:
     *
     * 输入:"IV"
     * 输出: 4
     * 示例3:
     *
     * 输入:"IX"
     * 输出: 9
     * 示例4:
     *
     * 输入:"LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例5:
     *
     * 输入:"MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    public static int romanToInt(String s) {
        int result = 0;
        int b = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int a = oneRomanToNum(s.charAt(i));
            if(b > a){
                result += b - a;
                i--;
            }else {
                result += a;
            }
            b = oneRomanToNum(s.charAt(i));
        }

        return result > 3999 ? 0 : result;
    }

    public static int oneRomanToNum(Character character){
        if(character == 'I'){
            return 1;
        }else if(character == 'V'){
            return 5;
        }else if(character == 'X'){
            return 10;
        }else if(character == 'L'){
            return 50;
        }else if(character == 'C'){
            return 100;
        }else if(character == 'D'){
            return 500;
        }else if(character == 'M'){
            return 1000;
        }
        return 0;
    }

    /**
     * 删除有序数组中的重复项
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * 在函数里修改输入数组对于调用者是可见的。
     * 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums.length;
        }
        int i = 0,j = 1;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    /**
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * 在函数里修改输入数组对于调用者是可见的。
     * 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *  print(nums[i]);
     * }
     *
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     *                   i j
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement(int[] nums, int val) {
        if(nums.length <=1 ){
            return nums.length == 1 ? nums[0] == val ? 0 : 1 : 0;
        }
        int i = 0, j = 1;
        while (j < nums.length){
            if(nums[i] == val){
                if(nums[j] != val){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    i++;
                }
                j++;
            }else {
                i++;
                j++;
            }
        }
        if(nums[nums.length -1] != val){
            i++;
        }
        return i;
    }

    public static int removeElement01(int[] nums, int val){
        int index = 0;
        for (int num : nums) {
            if(num != val){
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] ags) {
        int[] nums = {2,3,3,2};
        int length = removeElement01(nums, 2);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));
        HashMap<String, String> map = new HashMap<>();
        map.put("1","1");
    }
}
























