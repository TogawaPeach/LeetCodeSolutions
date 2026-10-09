package LeetCodeSolutions;

import java.util.HashMap;
import java.util.Map;

//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
//使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
public class Answer76 {
    //思路：滑动窗口 + 哈希表计数
    //need 记录 t 中每个字符需要出现的次数；window 记录当前窗口内各字符出现次数
    //right 扩张纳入字符，当窗口满足（包含 t 的所有字符含重复）后，left 收缩寻找更短的合法窗口
    //用 valid 记录"已经满足数量要求的字符种类数"，等于 need.size() 时窗口合法
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;                      // 满足数量要求的字符种类数
        int start = 0;                      // 最短窗口的起始位置
        int minLen = Integer.MAX_VALUE;     // 最短窗口长度

        while (right < s.length()) {
            // 右指针字符进入窗口
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 窗口已满足条件：收缩左指针，寻找更短合法窗口
            while (valid == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
