package LeetCodeSolutions;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
public class Answer11 {
    public int maxArea(int[] height) {
        //定义 当前一次容纳水的面积，最多容纳水的面积
        int NowWater = 0;
        int MaxWater = 0;
       //首先定义左右指针，一个在最左边，一个在最右边
        int left = 0;
        //-1为防止数组越界
        int right = height.length - 1;
        if(height.length == 0){
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            NowWater = ((right+1) - (left+1)) * Math.min(height[left],height[right]);
            //如果左边指针指示的高度小于右边，则左边指向下一个元素
            if (height[left] < height[right]) {
                left++;
            }else{
                right--;
            }
            //始终保留最大的数字
            MaxWater = Math.max(NowWater,MaxWater);
        }
        return MaxWater;
    }
}
