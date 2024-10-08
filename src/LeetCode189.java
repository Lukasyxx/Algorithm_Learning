public class LeetCode189 {
    public void rotate1(int[] nums, int k) {
        int n=nums.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[(i+k)%n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    public static void rotate2(int[] nums, int k){
        int n=nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    public static void reverse(int[] nums, int start, int end){
        while (start<end) {
            int temp=nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
