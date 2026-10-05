package LeetCodeSolutions;


//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class Answer42 {

    public int trap(int[] height) {
        //此题可以用木桶效应来说，接水的量取决于最短的一块板
        //定义左右两个指针，left指向数组的开头，right指向数组的尾部
        int left = 0;
        int right = height.length - 1;
        //总数
        int sum = 0;
        //定义左边最高的格子与右边最高的格子
        int LHighest = 0;
        int RHighest = 0;
        //当左右指针没有相遇时，处理较短的一侧
        while (left < right) {
            if (height[left] < height[right]) {
                LHighest = Math.max(LHighest, height[left]);
                sum += LHighest - height[left];
                left++;
            } else {
                RHighest = Math.max(RHighest, height[right]);
                sum += RHighest - height[right];
                right--;
            }
        }
        return sum;
    }
}
