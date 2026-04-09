import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1;
        for(int i=0; i<length; i++){
            char c = name.charAt(i);
            answer += Math.min(c-'A', 26-(c-'A'));
            int nextIndex = i+1;
            while(nextIndex < length && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }
            
            int turnLeft = (i*2) + (length - nextIndex);
            int turnRight = ((length - nextIndex) * 2) + i;
            
            minMove = Math.min(minMove, Math.min(turnLeft, turnRight));
        }
        
        answer += minMove;
        
        
        return answer;
    }
}