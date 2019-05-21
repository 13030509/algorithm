package leecode;

import java.util.HashMap;
import java.util.Map;

public class Solution14 {


    public boolean containsDuplicate(int[] nums) {

        Map<Integer,String> map = new HashMap<>();


        for (int i = 0; i < nums.length-1-i; i++) {

            if(nums[i] == nums[nums.length-1-i]){

                return true;
            }else{

                if(map.get(nums[i]) != null || map.get(nums[nums.length-1-i]) !=null){
                    return true;
                }else{
                    map.put(nums[i],"1");
                    map.put(nums[nums.length-1-i],"1");
                }

            }
        }
        return false;

    }
}
