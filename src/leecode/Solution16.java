package leecode;

public class Solution16 {

    public static int maxArea(int[] height) {

        int right = height.length - 1;
        int max = 0;
        int left = 0;

        while (left <= right) {


            int h;

            if (height[left] < height[right]) {
                h = height[left];
                left++;

            } else {
                h = height[right];
                right--;
            }


            max = max < h * (right - left + 1) ? h * (right - left + 1) : max;


        }
        return max;

    }

    public static void main(String[] args) {

        int x[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(x));

    }

}
