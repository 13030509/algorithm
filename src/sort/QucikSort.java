package sort;

public class QucikSort {

    public static void main(String[] args) {


        int[] arr = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        int end = arr.length - 1;
        quickSort(arr, 0, end);
        ArrayUtil.printArr(arr);

    }



    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = partition(arr, low, high);

        quickSort(arr, low, mid-1);
        quickSort(arr, mid+1, high);


    }

    public static int partition(int[] arr, int low, int high) {

        int val = arr[high];
        int p = low;
        int q = high;
        int i = p;

        for (int j = i; j < q ; j++) {
            if (arr[j] < val) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;

    }

}
