public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxprofit=0;
        int minprice=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }
            else if(prices[i]-minprice>maxprofit){
                maxprofit = prices[i]-minprice;
            }
        }
        return maxprofit;
    }
}
