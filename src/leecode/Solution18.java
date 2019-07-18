package leecode;

/*



给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution18 {


    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int re[] = new int[1001];
        int count[] = new int[1001];
        int res[] = new int[arr1.length];


        for (int element : arr1) {
            re[element] = 1;

        }

        for (int element : arr1) {
            count[element]++;
        }

        int index = 0;


        for (int element : arr2) {

            int times = count[element];

            for (int i = 0; i < times; i++) {
                res[index] = element;
                index++;
            }
            count[element] = 0;

        }


        for (int i = 0; i < 1001; i++) {

            int temp = count[i];
            if (temp > 0) {
                res[index] = i;
                index++;
                temp--;
            }
        }


        return res;


    }

    public static void main(String[] args) {


        int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int arr2[] = {2, 1, 4, 3, 9, 6};
        relativeSortArray(arr1, arr2);


    }

}
