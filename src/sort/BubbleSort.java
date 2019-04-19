package sort;

public class BubbleSort {



    /*
    冒泡排序是原地排序

     */
    public static void bubbleSort(int[] arr) {

        int length = arr.length;
        int count = 0;

        for (int i = 0; i < length - 1; i++) {

            boolean flag = true;

            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }

            }
            count++;
            if (flag) break;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        bubbleSort(arr);

        ArrayUtil.printArr(arr);


    }


}
