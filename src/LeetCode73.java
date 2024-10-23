import java.util.*;

public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        Set<Integer> row_index = new HashSet<Integer>();
        Set<Integer> column_index = new HashSet<Integer>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(!row_index.contains(i)){
                        row_index.add(i);
                    }
                    if(!column_index.contains(j)){
                        column_index.add(j);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row_index.contains(i)){
                    matrix[i][j] = 0;
                }
                if(column_index.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes3(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean flagcol0=false,flagrow0=false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) flagcol0=true;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) flagrow0=true;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagcol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagrow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
