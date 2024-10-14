public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int small=0, big=numbers.length-1;
        while (small<big) {
            int sum=numbers[big]+numbers[small];
            if(sum<target){
                small++;
            }
            else if(sum>target){
                big--;
            }
            else{
                return new int[]{small+1, big+1};
            }
        }

        return new int[]{-1, -1};
    }
}
