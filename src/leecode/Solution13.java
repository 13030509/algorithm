package leecode;


import java.util.Arrays;
import java.util.Random;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Solution13 {


    public static int search(int[] nums, int target) {

        if(nums.length==1 && nums[0] != target){
            return -1;
        }

        return bSearch(0, nums.length - 1, target, nums);
    }


    private static int bSearch(int low, int high, int target, int nums[]) {

        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);

        if (nums[mid] == target) {

            return mid;

        }
        else if((nums[mid] <= target && target <= nums[high]) || (nums[low] <= target && target <= nums[mid])) {

            //二分法排序

            while (low <= high) {

                mid = low + ((high - low) >> 1);

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

            return -1;

        }else if (nums[mid] > nums[high] ) {
            //所在区间为循环数组再分
            low = mid + 1;

            return bSearch(low, high, target, nums);

        } else if (nums[low] > nums[mid] ) {
            //所在区间为循环数组再分
            high = mid - 1;

            return bSearch(low, high, target, nums);

        }
        return -1;
    }

    public static void main(String[] args) {

        //性能对比


        int[] nums = new int[100000000];

        for (int i = 0; i < nums.length; i++) {

            nums[i] = new Random().nextInt(10000000);

        }

        int target = nums[4822282];

        Arrays.sort(nums);



         long begin = System.currentTimeMillis();
        System.out.println(begin);

        for (int i = 0; i < nums.length; i++) {

            if(target == nums[i]){
                break;
            }

        }
        //search(nums,target);

        System.out.println(System.currentTimeMillis());

    }
}
