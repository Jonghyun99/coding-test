import java.util.*;

class Solution {
    
    static HashSet<Integer> primeSet = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("",numbers, visited);
        
        return primeSet.size();
    }
    
    static void dfs(String current, String numbers, boolean[] visited) {
        if(!current.equals("")) {
            int num = Integer.parseInt(current);
            if(isPrime(num)) {
                primeSet.add(num);
            }
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    
    static boolean isPrime(int n) {
        if(n==1 || n==0) return false;
        for(int i=2;i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}