public class LeetCode45 {
    public int jump(int[] nums) {
        int most=0;
        int count=0;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            most = Math.max(most, i+nums[i]);
            if(i==end){
                end = most;
                count++;
            }
        }
        return count;
    }
}
