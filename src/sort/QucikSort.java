package sort;

public class QucikSort {

    public static void main(String[] args) {


        int[] arr = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        int end = arr.length - 1;
        quickSort(arr, 0, end);
        ArrayUtil.printArr(arr);

        int[] arr1 = {5, 2, 12, 52, 78, 2, 3, 1, 4, 0};
        findKElement(arr,5,0,arr1.length-1);


    }



    public static void quickSort(int[] arr, int low, int high) {

        //快速排序如果每次选择的点都不好 ， 时间复杂度会退化为O(n2) 优化方法 1 随机取 2 三数取中
        if (low >= high) {
            return;
        }

        int mid = partition(arr, low, high);

        quickSort(arr, low, mid-1);
        quickSort(arr, mid+1, high);


    }

    //查找第k大的元素 要求时间复杂度为O(n)

    public static void findKElement(int[] arr , int k ,int low, int high){


        int mid = partition(arr, low, high);

        if (mid +1 == k) {
            System.out.println("第" + k  + "大的元素为" + arr[mid]);
            return;
        }

        if(mid + 1 >k){
            findKElement(arr, k,low, mid-1);
        }else{
            findKElement(arr, k,mid+1, high);

        }

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
