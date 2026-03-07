class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Integer.toString(n,k).split("0");
        for(String s:str){
            if(s.isEmpty()) continue;
            long num = Long.parseLong(s);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean isPrime(long n) {
        if(n==0 || n==1) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}