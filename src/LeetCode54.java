import java.util.*;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return order;
        int m=matrix.length, n=matrix[0].length;
        int left=0,right=n-1,top=0,bottom=m-1;
        while (left<=right && top<=bottom) {
            for(int i=left;i<=right;i++){
                order.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                order.add(matrix[i][right]);
            }
            if(left<right && top<bottom){
                for(int i=right-1;i>=left+1;i--){
                    order.add(matrix[bottom][i]);
                }
                for(int i=bottom;i>=top+1;i--){
                    order.add(matrix[i][left]);
                }
            }
            left++;right--;top++;bottom--;
        }
        return order;
    }
}
