public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int fast=2, slow=2;
        while(fast<n){
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static void main(String[] args) {
        LeetCode80 l = new LeetCode80();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(l.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
