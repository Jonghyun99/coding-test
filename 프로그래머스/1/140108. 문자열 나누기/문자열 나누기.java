class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = ' ';
        int xCount = 0;
        int otherCount = 0;
        
        for(int i=0; i<s.length(); i++) {
            char target = s.charAt(i);
            if(xCount == 0 && otherCount == 0) {
                x = target;
            }
            
            if(x==target) {
                xCount++;
            } else {
                otherCount++;
            }
            
            if(xCount == otherCount) {
                answer++;
                xCount = 0;
                otherCount = 0;
            }
        }
        if(xCount!=0 || otherCount !=0){
            answer++;
        }        
        
        return answer;
    }
}