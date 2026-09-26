class Solution {
    public int maxProfit(int[] prices) {
     int min = Integer.MAX_VALUE;
     int profit = 0;

     for (int p :prices){
        if (p<min) min = p;
        else profit = Math.max(profit, p -min);
     }

     return profit;
        
    }
}