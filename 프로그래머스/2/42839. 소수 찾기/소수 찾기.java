import java.util.*;
class Solution {
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> set = new HashSet<>();
        dfs("", numbers, visited, set);
        
        return set.size();
    }
    
    static void dfs(String current, String numbers, boolean[] visited, Set<Integer> set) {
        if(!current.isEmpty()){
            if(isPrime(Integer.parseInt(current))) {
                set.add(Integer.parseInt(current));
            }
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current+numbers.charAt(i),numbers,visited, set);
                visited[i] = false;
            }
        }
        
    }
    
    static boolean isPrime(int n) {
        if(n==1||n==0) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}