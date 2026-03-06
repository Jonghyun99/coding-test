class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max=0;
        int min=0;
        for(int[] card:sizes) {
            int longer = Math.max(card[0], card[1]);
            int shorter = Math.min(card[0], card[1]);
            
            
            
            max = Math.max(longer,max);
            min = Math.max(shorter,min);
        }
        
        return max*min;
    }
}