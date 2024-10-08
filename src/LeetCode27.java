public class LeetCode27 {
    public int removeElement1(int[] nums, int val) {
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int removeElement2(int[] nums, int val) {
        int left=0, right=nums.length;
        while(left<right){
            if(nums[left]==val){
                nums[left] = nums[right-1];
                right--;
            }
            else{
                left++;
            }
        }
        return left;
    }
}
