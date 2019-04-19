package sort;

public class MergeSort {


    public static void main(String[] args) {


        int[] arr = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        int end = arr.length - 1;
        mergeSort(arr, 0, end);
        ArrayUtil.printArr(arr);

    }


    public static void mergeSort(int[] arr, int begin, int end) {

        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        mergeArr(arr, begin, mid, end);

    }


    public static void mergeArr(int arr[], int begin, int mid, int end) {
        int newLength = end - begin + 1;
        int[] temp = new int[newLength];

        int p1s = begin;
        int p1e = mid;

        int p2s = mid + 1;
        int p2e = end;
        int i = 0;
        while (p1s <= p1e && p2s <= p2e) {
            if (arr[p1s] > arr[p2s]) {
                temp[i++] = arr[p2s++];
            } else {
                temp[i++] = arr[p1s++];
            }
        }

        if (p1s > p1e) {
            while (p2s <= p2e)
                temp[i++] = arr[p2s++];
        } else {
            while (p1s <= p1e)
                temp[i++] = arr[p1s++];
        }


        for (int j = 0; j < newLength; j++) {
            arr[begin++] = temp[j];
            System.out.print(temp[j] + " ");
        }

        System.out.println();

    }
}
