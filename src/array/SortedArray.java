package array;

public class SortedArray {

    private int lastIndex = 0;

    private final int capacity = 10;

    int[] sortedArray = new int[capacity];


    public void add(int num) {


        if (lastIndex == capacity) {
            return;
        }

        if (lastIndex == 0) sortedArray[lastIndex] = num;
        else {
            int i = lastIndex;
            for (; i > 0 && num < sortedArray[i - 1]; i--) {
                sortedArray[i] = sortedArray[i - 1];
            }
            sortedArray[i] = num;
        }
        lastIndex++;
    }

    public boolean remove(int index) {

        if (index > capacity || index > lastIndex) {
            return false;
        } else {
            for (int i = index; i < lastIndex; i++) {
                sortedArray[i] = sortedArray[i + 1];
            }
            lastIndex--;
        }
        return true;

    }


    public int get(int index) {

        if (index > capacity || index > lastIndex) {
            return -1;
        } else {
            return sortedArray[index];

        }
    }

    public void printAll() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();

        sortedArray.add(5);
        sortedArray.add(3);
        sortedArray.add(10);
        sortedArray.add(1);
        sortedArray.add(2);
        System.out.println(sortedArray.get(3));
        sortedArray.printAll();
        System.out.println(sortedArray.remove(2));
        sortedArray.printAll();


    }


}
