public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minprice=0;
        int maxprofit=0;
        for(int i=0;i<n;i++){
            if(prices[i]<prices[minprice]){
                minprice=i;
            }
            else{
                maxprofit += prices[i]-prices[minprice];
                minprice=i;
            }
        }
        return maxprofit;
    }
}
