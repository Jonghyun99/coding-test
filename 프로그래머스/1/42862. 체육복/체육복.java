class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] student = new int[n+2];
        
        for(int r:reserve) {
            student[r]++;
        }
        
        for(int l:lost) {
            student[l]--;
        }
        
        for(int i=1; i<=n; i++){
            if(student[i]== -1) {
                if(student[i-1] == 1) {
                    student[i-1]--;
                    student[i]++;
                } else if (student[i+1] == 1) {
                    student[i+1]--;
                    student[i]++;
                } else {
                    answer--;
                } 
            }
        }
        return answer;
    }
}