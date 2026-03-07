class Solution {
    public int solution(String s) {
        char x = ' ';
        int xCount = 0;
        int otherCount = 0;
        int answer = 0;
        for(char c:s.toCharArray()) {
            if(xCount==0 && otherCount == 0) {
                x = c;
            }
            
            if(x==c) xCount++;
            else otherCount++;
            
            if(xCount==otherCount){
                answer++;
                xCount=0;
                otherCount=0;
            }
        }
        if(xCount!=0 || otherCount != 0) answer++;
        return answer;
    }
}