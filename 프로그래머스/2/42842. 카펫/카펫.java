class Solution {
    public int[] solution(int brown, int yellow) {
        
        // yellow의 width와 height를 구하여야함
        // 1. yellow = yw * yh
        // 2. brown = (yw + 2) * 2 + (yh * 2)
        int[] ans = new int[2];
        int width = 0;
        int height = 0;
        for(int yw = 1; yw<=yellow; yw++) {
            int yh = 0;
            if(yellow%yw==0)  
                yh = yellow/yw;
            
            width = yw+2;
            height = yh+2;
            
            if(width * 2 + (height-2)*2 == brown) {
                ans[0] = height;
                ans[1] = width;
                return ans;
            }
        }
        return ans;
    }
}