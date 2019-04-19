package sort;

public class InsertSort {


    public static void insertSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int value = arr[i];
            int j = i;

            for (; j > 0; j--) {

                if (arr[j - 1] > value) {
                    //后移一位
                    arr[j] = arr[j - 1];

                } else {
                    break;
                }
            }

            //插入数据
            arr[j] = value;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        insertSort(arr);
        ArrayUtil.printArr(arr);
    }
}
