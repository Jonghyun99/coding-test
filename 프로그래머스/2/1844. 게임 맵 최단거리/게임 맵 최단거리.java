import java.util.*;

class Solution {
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};
    public int solution(int[][] maps) {
        
        int maxRow = maps.length-1;
        int maxCol = maps[0].length-1;
        
        bfs(0,0,maps, maxRow, maxCol);
        if(maps[maxRow][maxCol] == 1) return -1;
        
        return maps[maxRow][maxCol] - 1;
    }
    
    static void bfs(int startRow, int startCol, int[][] maps, int maxRow, int maxCol) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startRow, startCol});
        
        
        
        maps[startRow][startCol]++;
        
        
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            
            if(nowRow == maxRow && nowCol == maxCol) return;
            
            for(int i=0; i<4; i++) {
                int nextRow = nowRow + drow[i];
                int nextCol = nowCol + dcol[i];
                
                if(nextRow < 0 || nextCol < 0 || nextRow > maxRow || nextCol > maxCol) 
                   continue; 
                
                if(maps[nextRow][nextCol] == 1) {
                    maps[nextRow][nextCol] = maps[nowRow][nowCol] + 1;
                    q.add(new int[] {nextRow, nextCol});
                }
                
            }
        }
    }
}




