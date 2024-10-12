public class LeetCode274 {
    public int hIndex1(int[] citations) {
        int p=citations.length;
        int n=citations.length;
        int res=0;
        while(res<p){
            int count=0;
            for(int i=0;i<n;i++){
                if(citations[i]>=p){
                    count++;
                }
            }
            res = Math.min(count, p);
            p--;
        }
        return res;
    }

    public int hIndex2(int[] citations) {
        int n=citations.length, total=0;
        int[] counter = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                counter[n]++;
            }
            else{
                counter[citations[i]]++;
            }
        }
        for(int i=n;i>=0;i--){
            total += counter[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}
