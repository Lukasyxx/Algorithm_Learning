public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int most=0;
        for(int i=0;i<nums.length;i++){
            if(i<=most){
                most=Math.max(most,i+nums[i]);
                if(most>=nums.length-1) return true;
            }
        }
        return false;
    }
}
