package LeetCodeSolutions;


//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class Answer283 {
    public void moveZeroes(int[] nums) {
        // slow 指向"下一个非零元素要放置的位置"，fast 用于扫描整个数组
        int slow = 0;
        int temp;
        // 移动 fast，若 fast 指向的目标为 0，则继续指向下一个目标，
        // 若不为 0，则交换 fast 与 slow 的数字，同时 slow 指向 slow 的下一个位置
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

}
