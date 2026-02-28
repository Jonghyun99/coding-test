import java.util.*;

class Solution {
    public int solution(String s) {
        int  answer = 0;
        
        char x = ' '; //기준글자
        int xCount = 0; // 기준글자 카운트
        int otherCount = 0; // 다른 글자 카운트
        
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(xCount==0 && otherCount == 0){
                x=c;
                xCount++;
                continue;
            }
            if(x==c) {
                xCount++;
            } else {
                otherCount++;
            }
            
            if(xCount==otherCount) {
                answer++;
                xCount=0;
                otherCount=0;
            }
        }
        
        if(xCount !=0 || otherCount!=0) {
            answer++;
        }
        
        
        return answer;
    }
}