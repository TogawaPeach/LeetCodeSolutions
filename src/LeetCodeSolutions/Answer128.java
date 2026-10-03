package LeetCodeSolutions;

import java.util.*;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
public class Answer128 {



    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //排序
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1])
                continue;//遇到重复元素跳过
            if(nums[i] == nums[i-1] + 1)
                count++;//相邻元素差值必为1，所以此时count++
            else{//如果差值不为1了，就说明此时断了
                //永远记录最大的，比如这次count没达到之前的max，之前的max还是最大
                max = Math.max(max,count);
                //重置count为1
                count = 1;
            }
        }
        return Math.max(count,max);




    }
}
