public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=1) return n;
        int fast=1, slow=1;
        while(fast<n){
            if(nums[fast]!=nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
