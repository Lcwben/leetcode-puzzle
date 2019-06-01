package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 中难度第3题：
 * 无重复字符的最长子串（Longest Substring Without Repeating Characters）
 */
public class MediumNo3 {

    public int lengthOfLongestSubstring(String s) {

        int subStrLength = 0; //存储不重复的最长子字符串的长度值
        int left = 0; //当字符串头一个字符的位置
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char subChar = s.charAt(i);
            //当程序检测到重复的字符
            if (map.containsKey(subChar)) {
                //舍弃该字符串当前头一个字符（把代表头一个字符的位置的left变量向高位移位）
                left = left < map.get(subChar)+1 ? map.get(subChar)+1 : left;
            }

            map.put(subChar, i);
            subStrLength = subStrLength < (i-left+1) ? i-left+1 : subStrLength;
        }
        return subStrLength;
    }

    public static void main(String[] args) {
        MediumNo3 m3 = new MediumNo3();
        int res = m3.lengthOfLongestSubstring("bcbcdb");
        System.out.println(res);
    }

}
