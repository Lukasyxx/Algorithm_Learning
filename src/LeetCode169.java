import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
    
    public int majorityElement2(int[] nums) {
        int n=nums.length;
        int major=nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]==major){
                count++;
            }
            else if(count==0){
                major=nums[i];
                count++;
            }
            else{
                count--;
            }
        }
        return major;
    }
}
