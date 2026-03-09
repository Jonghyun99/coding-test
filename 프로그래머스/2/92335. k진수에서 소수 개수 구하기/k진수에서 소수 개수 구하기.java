class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] numStr = Integer.toString(n,k).split("0");
        for(String str:numStr) {
            if(!str.isEmpty()) {
                if(isPrime(str)) answer++;
            }
        }
        return answer;
    }
    
    static boolean isPrime(String str) {
        long num = Long.parseLong(str);
        if(num==1 || num==0) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}