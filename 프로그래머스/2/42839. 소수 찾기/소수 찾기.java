import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        dfs("", numbers,visited);
        
        return set.size();
    }
    
    static void dfs(String current, String numbers, boolean[] visited) {
        if(!current.isEmpty()) {
            if(isPrime(Integer.parseInt(current))) {
                set.add(Integer.parseInt(current));
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
    
    static boolean isPrime(int num) {
        if(num==0||num==1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}