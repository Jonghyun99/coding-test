class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
    
    static void dfs(int node, int[][] computers) {
        visited[node] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(i!=node && computers[node][i] == 1 && !visited[i]) {
                dfs(i,computers);
            }
        }
    }
}