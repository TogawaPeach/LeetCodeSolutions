package LeetCodeSolutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
public class Answer438 {
    //力扣438题我的思路是这样的，首先对p的字符串获取每个字母以及出现的次数，
    // 然后定义左右指针，左右指针之间的距离为p的长度，然后每次移动均计算窗口内字符及出现的次数，
    // 相同的情况下就记录left的位置，不同的情况下left和right均++，直到right到达s的length-1位置
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return result;
        }

        // p 和窗口的字母频次表
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 第一个窗口 [0, pLen-1]
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        // 滑动窗口：left 与 right 同步右移，窗口大小恒为 pLen
        for (int left = 0, right = pLen; right < sLen; left++, right++) {
            sCount[s.charAt(right) - 'a']++;   // 右指针字符进窗口
            sCount[s.charAt(left) - 'a']--;    // 左指针字符出窗口
            if (Arrays.equals(sCount, pCount)) {
                result.add(left + 1);          // 新窗口起点为 left + 1
            }
        }

        return result;
    }
}
