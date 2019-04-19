package leecode;

/*

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


 */
public class Solution6 {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;

        int k = 0;
        int max = 1;

        for (int i = 1; i < length; i++) {
            int count = 1;
            for (int j = k; j < i; j++) {

                if (chars[j] == chars[i]) {
                    k = j + 1;
                    break;
                } else {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
