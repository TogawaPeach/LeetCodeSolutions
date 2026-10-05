package LeetCodeSolutions;

import java.util.*;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
public class Answer3 {

    public int lengthOfLongestSubstring(String s) {

        //把字符串转为char数组，方便用下标访问
        char[] chars = s.toCharArray();
        //定义左右两个指针，一开始均指向字符串的第一个字母
        int left = 0;
        int right = 0;
        //记录当前窗口内出现过的字符
        java.util.Set<Character> window = new java.util.HashSet<>();
        //记录最长子串长度
        int maxLen = 0;

        //右指针一直向右扩张，直到字符串末尾
        while (right < chars.length) {
            if (!window.contains(chars[right])) {
                //右指针所在字符没出现过，加入窗口并扩张
                window.add(chars[right]);
                right++;
                //当前窗口长度 = right - left
                maxLen = Math.max(maxLen, right - left);
            } else {
                //出现重复，左指针收缩，移出左边字符
                window.remove(chars[left]);
                left++;
            }
        }
        return maxLen;
    }
}
