import java.util.*;
class Solution {
    
    // 음수 구분 없이 가장 큰 숫자를 만들어야 함
    // 숫자끼리 정렬하여, 큰 숫자 끼리는 곱셈을, 작은 숫자 
    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c:expression.toCharArray()) {
            if(c=='+' || c=='-' || c=='*') {
                ops.add(c);
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        
        char[][] priorities = {
            {'+','-','*'},{'+','*','-'},
            {'-','+','*'},{'-','*','+'},
            {'*','+','-'},{'*','-','+'}
        };
        
        for(char[] p : priorities){
            // 깊은복사
            List<Long> tempNums = new ArrayList<>(numbers);
            List<Character> tempOps = new ArrayList<>(ops);
            
            for(char op:p) {
                for(int i=0; i< tempOps.size();) {
                    if(tempOps.get(i) == op) {
                        long res = calc(tempNums.get(i),tempNums.get(i+1), op);
                        
                        tempNums.remove(i+1);
                        tempNums.set(i, res);
                        tempOps.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tempNums.get(0)));
        }
        
        return answer;
    }
    
    private long calc(long a,long b,long op) {
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        return a*b;
    }
}