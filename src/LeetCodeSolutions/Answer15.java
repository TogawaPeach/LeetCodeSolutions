package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
public class Answer15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //首先对nums进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        //首先我们选定一个数字 nums[i] 作为三元组的第一个数
        for (int i = 0; i < n - 2; i++) {
            //去重①：选定的第一个数如果和上一个相同，跳过，避免重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //排序后若选定的数已经大于0，后面只会更大，不可能再凑成 0，直接结束
            if (nums[i] > 0) {
                break;
            }
            //差值：选定的数与 0 的差值，即需要 nums[left] + nums[right] 等于它
            int target = -nums[i];
            //定义左右指针
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    //找到一个结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重②：跳过左右两边重复的元素，避免重复三元组
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //同时向中间收缩
                    left++;
                    right--;
                } else if (sum > target) {
                    //比差值大，右指针左移（右移会更小）
                    right--;
                } else {
                    //比差值小，左指针右移（右移会更大）
                    left++;
                }
            }
        }
        return result;
    }
}
