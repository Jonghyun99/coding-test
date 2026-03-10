import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        List<Long> nList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c:expression.toCharArray()){
            if(c=='+' || c=='-' || c=='*') {
                opList.add(c);
                nList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        nList.add(Long.parseLong(sb.toString()));
        
        char[][] priority = {
            {'+','-','*'},{'+','*','-'},
            {'-','+','*'},{'-','*','+'},
            {'*','+','-'},{'*','-','+'}
        };
        
        for(char[] p:priority) {
            List<Long> tempNList = new ArrayList<>(nList);
            List<Character> tempOpList = new ArrayList<>(opList);
            for(char op:p){
                for(int i=0; i<tempOpList.size();) {
                    if(op==tempOpList.get(i)) {
                        long res = calc(tempNList.get(i), tempNList.get(i+1), tempOpList.get(i));
                        tempNList.remove(i);
                        tempNList.set(i,res);
                        tempOpList.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tempNList.get(0)));
        }
        
        return answer;
    }
    
    static long calc(long a, long b, char op) {
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        return a*b;
    }
}