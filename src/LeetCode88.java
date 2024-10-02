public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0;
        int[] temp = new int[m+n];
        int index = 0;
        while(i<m && j<n){
            temp[index++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i<m){
            temp[index++] = nums1[i++];
        }
        while(j<n){
            temp[index++] = nums2[j++];
        }
        for(int k=0; k<m+n; k++){
            nums1[k] = temp[k];
        }
    }
}
