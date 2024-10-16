import java.util.*;;
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(nums == null || n < 3) return res;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1, r=n-1;
            while (l<r) {
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else if(sum>0) r--;
            }
        }
        return res;
    }
}
