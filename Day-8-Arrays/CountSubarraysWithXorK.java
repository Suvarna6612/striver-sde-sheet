
import java.util.HashMap;

class CountSubarraysWithoutXorK {
    public int subarraysWithXorK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int xr = 0;
        int count = 0;

        // Important for exact xor = k
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {

            xr = xr ^ nums[i];

            int x = xr ^ k;

            if(map.containsKey(x)) {
                count += map.get(x);
            }

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }
}