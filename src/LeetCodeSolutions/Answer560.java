package LeetCodeSolutions;


import java.util.HashMap;
import java.util.Map;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
public class Answer560 {
    public int subarraySum(int[] nums, int k) {

        // key：前缀和，value：这个前缀和出现过几次
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;

            // 当前前缀和 - 以前的前缀和 = k
            // 所以，要找以前有多少个前缀和等于 sum - k
            ans += count.getOrDefault(sum - k, 0);

            // 查询之后，再记录当前前缀和
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return ans;

    }
}
