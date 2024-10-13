public class LeetCode134 {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n=gas.length,i=0;
        while(i<n){
            int sumofgas=0,sumofcost=0;
            int cnt=0;
            while(cnt<n){
                int j=(i+cnt)%n;
                sumofgas += gas[j];
                sumofcost += cost[j];
                if(sumofcost>sumofgas){
                    break;
                }
                cnt++;
            }
            if(cnt==n){
                return i;
            }
            else{
                i = i+cnt+1;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int curSum = 0, totalSum = 0;
        for(int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
    
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        for(int g : gas) sumGas += g;
        for(int c : cost) sumCost += c;
        if(sumGas < sumCost) return -1;

        int sum = 0, index = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        return index;
    }
}
