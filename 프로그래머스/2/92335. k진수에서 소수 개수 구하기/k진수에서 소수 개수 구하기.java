import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n,k);
        String[] parts = num.split("0");
        
        for(String part: parts) {
            if(part.isEmpty()) continue;
            
            long number = Long.parseLong(part);
            if(isPrime(number)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) { 
        if(n<=1) return false;
        
        for(long i=2; i<=Math.sqrt(n); i++){
            if(n%i ==0) return false;
        }
        return true;
    }
}