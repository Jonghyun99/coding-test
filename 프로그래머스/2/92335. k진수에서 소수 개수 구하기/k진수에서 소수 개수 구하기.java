class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] baseStr = Integer.toString(n,k).split("0");
        for(String base:baseStr) {
            if(base.isEmpty()) continue;
            
            if(isPrime(Long.parseLong(base))) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) {
        if(n==1) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}