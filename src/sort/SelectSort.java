package sort;

public class SelectSort {


    public static void selectSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n ; j++) {
                if (arr[minIndex] > arr[j]) {

                    //选择最小元素
                    minIndex = j;
                }
            }
            //交换
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        selectSort(arr);
        ArrayUtil.printArr(arr);
    }


}
