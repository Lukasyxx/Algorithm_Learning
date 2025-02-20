public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        int m=haystack.length(), n=needle.length();
        if(n==0) return 0;
        if(m==0 || m<n) return -1;
        int[] next = buildNextArray(needle);
        int i=0,j=0;
        while(i<m && j<n){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            else{
                if(j==0) i++;
                else j=next[j-1];
            }
        }
        if(j==n) return i-j;
        else return -1;
    }
    private int[] buildNextArray(String needle){
        int n=needle.length();
        int[] next = new int[n];
        int i=1,j=0;
        while(i<n){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                next[i]=j;
                i++;
            }
            else{
                if(j==0){
                    next[i]=0;
                    i++;
                }
                else{
                    j=next[j-1];
                }
            }
        }
        return next;
    }
}
