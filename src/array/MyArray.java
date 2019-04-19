package array;

public class MyArray {

    private int capacity = 10;

    private int modCount = 0;

    private String[] sourceArray;


    public MyArray() {
        sourceArray = new String[capacity];
    }


    public MyArray(int capacity) {
        this.capacity = capacity;
        sourceArray = new String[capacity];
    }

    private void arrayGrow(String data) {

        String targetArr[] = new String[2 * capacity];
        targetArr[capacity] = data;

        for (int i = 0; i < capacity; i++) {
            targetArr[i] = sourceArray[i];
        }
        capacity = 2 * capacity;
        sourceArray = targetArr;

    }

    public void add(String data) {
        if (modCount == capacity) {
            arrayGrow(data);
        } else {
            sourceArray[modCount] = data;
        }
        modCount++;
    }

    public void printArr() {
        for (int i = 0; i < modCount; i++) {
            System.out.print(sourceArray[i] + " ");
        }
        System.out.println("the length is " + capacity);
    }


    public static void main(String[] args) {

        MyArray dynamicArray = new MyArray(5);

        dynamicArray.add("1");
        dynamicArray.add("2");
        dynamicArray.add("3");
        dynamicArray.add("4");
        dynamicArray.add("5");

        dynamicArray.printArr();

    }


}
