public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0,ans=n+1,sum=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return ans<=n? ans:0;
    }
}
