package search;

public class BSearch {


    public static int Bsearch(int[] arr, int low, int high, int val) {

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    //变体一：查找第一个值等于给定值的元素

    public static int BsearchTransForm1(int[] arr, int low, int high, int val) {

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] == val) {

                if (mid == 0 || arr[mid - 1] != val) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    //变体二：查找最后一个值等于给定值的元素

    public static int BsearchTransForm2(int[] arr, int low, int high, int val) {
        int length = high + 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] == val) {

                if (mid == length - 1 || arr[mid + 1] != val) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


    //变体三：查找第一个大于等于指定值的元素

    public static int BsearchTransForm3(int[] arr, int low, int high, int val) {

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (val <= arr[mid]) {

                if (mid == 0 || arr[mid - 1] < val) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            } else {
                low = mid + 1;

            }

        }
        return -1;
    }


    //变体四：查找最后一个小于等于给定值的元素 1 3 5 6 7 8 9  arr[mid] = 6 val = 4     arr[mid] <= val  < arr[mid + 1]

    public static int BsearchTransForm4(int[] arr, int low, int high, int val) {

        int length = high + 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] <= val) {

                if (mid == length - 1 || arr[mid + 1] > val) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else {

                high = mid - 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 12, 12, 14, 14, 14, 28, 38, 68, 99, 121, 422, 523};

        int index = BsearchTransForm4(arr, 0, arr.length - 1, 11);

        System.out.println(index);

    }
}
