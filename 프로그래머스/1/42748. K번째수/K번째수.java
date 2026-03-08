import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        
        for(int[] command:commands) {
            int s = command[0]-1;
            int e = command[1];
            int t = command[2]-1;
            
            int[] sub = Arrays.copyOfRange(array,s,e);
            Arrays.sort(sub);
            answer[idx++] = sub[t];
        }
            return answer;
        
    }
}