class Solution {
    static int maxDeepth = -1;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(0, k,dungeons, visited);
        
        return maxDeepth;
    }
    
    static void dfs(int deepth, int k, int[][] dungeons, boolean[] visited) {
        maxDeepth = Math.max(deepth, maxDeepth);
        
        for(int i=0; i<dungeons.length; i++) {
            int needsK = dungeons[i][0];
            int costK = dungeons[i][1];
            
            if(needsK<=k && !visited[i]) {
                visited[i] = true;
                dfs(deepth+1, k-costK, dungeons,visited);
                visited[i] = false;
            }
        }
    }
}