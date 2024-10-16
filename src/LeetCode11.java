public class LeetCode11 {
    public int maxArea(int[] height) {
        int maxwater=0;
        int l=0,r=height.length-1;
        while (l<r) {
            int water=Math.min(height[l], height[r])*(r-l);
            maxwater = Math.max(maxwater, water);
            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxwater;
    }
}
