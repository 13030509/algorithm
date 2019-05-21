package leecode;

import java.util.HashMap;
import java.util.Map;

public class Solution15 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int lth = nums.length;



        for (int i = 0; i < lth ; i++) {

            Integer vari = map.get(nums[i]);

            if(vari !=null && (i-vari)<=k){
                return true;

            }
            map.put(nums[i],i);

        }
        return false;
    }

}
