package leecode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution7 {

    public static String longestPalindrome(String s) {

        int length = s.length();
        char[] chars = s.toCharArray();

        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return s;
        }

        int gap = length;

        for (; gap > 0; gap--) {


            for (int i = 0; i < length - gap + 1; i++) {

                int startIndex = i;
                int endIndex = i + gap - 1;

                while (startIndex <= endIndex) {

                    if (chars[startIndex] == chars[endIndex] && (startIndex + 1 == endIndex || startIndex == endIndex)) {

                        return s.substring(i, i+gap);

                    } else if(chars[startIndex] != chars[endIndex]){
                        break;

                    }else{
                        startIndex++;
                        endIndex--;
                    }

                }

            }
        }

        return "";
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("aaabaaaa"));
    }


}
