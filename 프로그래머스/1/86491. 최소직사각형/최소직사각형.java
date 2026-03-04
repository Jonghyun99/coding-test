class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int[] card:sizes) {
            int longer =  Math.max(card[0], card[1]);
            int shorter =  Math.min(card[0], card[1]);
            
            maxWidth = Math.max(maxWidth,longer);
            maxHeight = Math.max(maxHeight,shorter);
        }
        
        return maxWidth * maxHeight;
        
    }        
    
    // static int dfs(int[][] sizes, )
}