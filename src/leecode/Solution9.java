package leecode;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Solution9 {


    public static int reverse(int x) {

        String val = String.valueOf(x);
        int length = val.length();

        if (x < 0) {
            val = val.substring(1, length);
        }

        for (int i = 0; i < val.length(); i++) {

            if (Long.valueOf(val) % 10 == 0) {
                val = String.valueOf(Long.valueOf(val) / 10);
            } else {
                break;
            }

        }

        char[] chars = val.toCharArray();

        long sum = 0;

        long[] cache = new long[val.length()];

        cache[0] = 1;
        for (int i = 1; i < val.length(); i++) {

            cache[i] = 10 * cache[i - 1];

        }


        for (int i = 0; i < val.length(); i++) {

            sum = sum + Long.parseLong("" + chars[i]) * cache[i];

        }


        if (x < 0 && 0 - sum >= -2147483648) {

            return 0 - (int) sum;

        } else if (sum <= 2147483647) {

            return (int) sum;
        }

        return 0;

    }

    public static void main(String[] args) {
        reverse(1534236469);
    }


}
