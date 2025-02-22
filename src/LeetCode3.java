import java.util.*;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<=1) return n;
        Set<Character> cnt = new HashSet<Character>();
        int maxLen=0, left=0;
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            while (cnt.contains(ch)) {
                cnt.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            cnt.add(ch);
        }
        return maxLen;
    }
}
