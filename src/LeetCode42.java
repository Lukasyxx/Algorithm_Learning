import java.util.*;

public class LeetCode42 {
    public int trap1(int[] height) {
        int n=height.length;
        int ans=0;
        int[] pre_max=new int[n];
        int[] suf_max=new int[n];
        pre_max[0] = height[0];
        suf_max[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            pre_max[i] = Math.max(height[i], pre_max[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suf_max[i] = Math.max(height[i], suf_max[i+1]);
        }
        for(int i=0;i<n;i++){
            ans += Math.min(pre_max[i], suf_max[i]) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int n=height.length;
        int ans=0;
        int pre_max = 0;
        int suf_max = 0;
        int left=0, right=n-1;
        while (left<right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if(pre_max>suf_max){
                ans += suf_max - height[right];
                right--;
            }
            else{
                ans += pre_max - height[left];
                left++;
            }
        }
        return ans;
    }

    public int trap3(int[] height) {
        int n=height.length;
        int ans=0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()) break;
                int left=stack.peek();
                int h=Math.min(height[left], height[i]) - height[top];
                int w=i-left-1;
                ans += w*h;
            }
            stack.push(i);
        }
        return ans;
    }
}
