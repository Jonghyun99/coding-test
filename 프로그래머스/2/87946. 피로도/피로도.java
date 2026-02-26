import java.util.*;
class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        DFS(0,k,dungeons,visited);
        return answer;
    }
    
    static void DFS(int deepth, int k, int[][] dungeons, boolean[] visited){
        answer = Math.max(answer, deepth);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                DFS(deepth+1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
        
    }
}