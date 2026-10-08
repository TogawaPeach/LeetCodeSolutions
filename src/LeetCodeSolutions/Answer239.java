package LeetCodeSolutions;

import java.util.*;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
public class Answer239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //思路是使用单调队列，队列的第一个永远是最大值，窗口每滑动一次，
        //剔除滑出的元素，新加的元素按顺序排入，每次均返回第一个值
        int n = nums.length;
        int[] result = new int[n - k + 1];
        //双端队列，存的是下标；队列内对应的值保持从大到小（单调递减）
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //入队前，从队尾弹出所有比当前值小的元素，维持单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //当前元素下标入队
            deque.offerLast(i);
            //队首下标若已滑出窗口，弹出
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //窗口填满后，队首即为当前窗口最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
