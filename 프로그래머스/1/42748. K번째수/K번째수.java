import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx=0;
        for(int[] command:commands) {
            int s = command[0]-1;
            int e = command[1];
            int t = command[2];
            
            int[] a = new int[e-s]; 
            int idx = 0;
            for(int i = s; i<e; i++) {
                a[idx++] = array[i];
            }
            Arrays.sort(a);
            answer[answerIdx++] = a[t-1];
        }        
        
        return answer;
    }
}