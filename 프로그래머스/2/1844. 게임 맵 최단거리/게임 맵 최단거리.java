import java.util.*;
class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length+1][maps[0].length+1];
        bfs(0,0, maps);
        int cnt = maps[maps.length-1][maps[0].length-1];
        if(cnt==1) return -1;
        return cnt-1;
    }
    
    static void bfs(int N, int M, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N,M});
        maps[N][M] = maps[N][M] + 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            if(nowX==maps.length-1 && nowY==maps[nowX].length -1) {
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];
                if(nextX<maps.length && nextY<maps[0].length && nextX>=0 && nextY>=0){
                    if(maps[nextX][nextY] == 1) {
                        maps[nextX][nextY] = maps[nowX][nowY] + 1;
                        q.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}