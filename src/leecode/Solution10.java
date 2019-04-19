package leecode;

/**
 *
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Solution10 {


    public static int myAtoi(String str) {

        str = str.trim();
        int index = str.indexOf(" ");

        char[] chars = str.toCharArray();
        char[] resChars = new char[chars.length];

        int modCount = 0;

        if(index == -1 ){
            index = chars.length;
        }

        for (int i = 0; i < index; i++) {

            if (chars[i] == 32) {
                break;
            }
            if ((chars[i] >= 48 && chars[i] <= 57) || chars[i] == '-' || chars[i] == '+') {
                if (modCount > 0 && (chars[i] == '-' || chars[i] == '+')) {
                    break;
                }
                resChars[modCount++] = chars[i];
            } else {
                break;
            }


        }
        StringBuffer sb = new StringBuffer();

        if ((modCount == 1 && (resChars[0] == '-' || resChars[0] == '+'))) {
            return 0;
        }

        for (int i = 0; i < modCount; i++) {
            sb.append(resChars[i]);
        }

        if ("".equals(sb.toString())) {
            return 0;
        }
        try {
            Integer.parseInt(sb.toString());
        } catch (Exception e) {
            if (resChars[0] == '-') {
                return -2147483648;

            } else {

                return 2147483647;
            }
        }


        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {

        System.out.println(myAtoi("42"));
    }


}
