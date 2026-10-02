package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。


public class Answer49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String key = sortWord(strs[i]);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }


    public String sortWord(String word){
        //把string单词拆分为一个一个的char并成为数组
        char[] chars = word.toCharArray();
        //对char进行排序
        Arrays.sort(chars);
        return new String(chars);
    }
}
