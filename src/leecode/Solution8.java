package leecode;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest" "testnoc edoCteeL ekat s'teL"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution8 {

    public static String reverseWords(String s) {

        String[] strings = s.split(" ");
        StringBuilder restStrings = new StringBuilder();


        for (int i = strings.length ; i >  0 ; i--) {

            restStrings.append(strings[i-1] + " ");

        }

        restStrings.setLength(restStrings.length() - 1);


        char[] chars = restStrings.toString().toCharArray();

        for (int i = 0; i < chars.length/2; i++) {

            char temp = chars[i];

            chars[i] = chars[chars.length - i - 1] ;

            chars[chars.length - i - 1] = temp;

        }

        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }
}
