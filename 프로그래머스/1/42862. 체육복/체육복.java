class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] s = new int[n+2];
        
        for(int i=1; i<=n; i++) {
            s[i] = 1;
        }
        
        for(int num:lost){
            s[num]--;
        }
        
        for(int num:reserve){
            s[num]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(s[i] == 0) {
                if(s[i-1] >= 2){
                    s[i]++;
                    s[i-1]--;
                } else if(s[i+1] >= 2) {
                    s[i]++;
                    s[i+1]--;
                }
            }
        }
        
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(s[i]>=1) cnt++;
        }
        
        return cnt;
        
    }
}