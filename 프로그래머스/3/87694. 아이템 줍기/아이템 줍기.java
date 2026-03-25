import java.util.*; 

class Solution {
    
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist; // 이동 거리 관리
        }
    }
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        for(int [] rec:rectangle) {
            int leftX = rec[0] *2;
            int leftY = rec[1] *2;
            int rightX = rec[2] *2;
            int rightY = rec[3] *2;
            
            for(int i=leftY; i<=rightY; i++) {
                for(int j=leftX; j<=rightX; j++){
                    if(map[i][j] == 2) continue;
                    
                    if(i==leftY || i== rightY || j==rightX || j==leftX) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        
        return bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];
        q.add(new Node(characterY, characterX,0));
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowY = now.x;
            int nowX = now.y;
            
            if(nowY == itemY && nowX == itemX) {
                return now.dist/2;
            }
            
            for(int i=0; i<4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                
                if(nextY>=1 && nextX>=1 && nextX<=101 && nextY<=101) {
                    if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.add(new Node(nextY, nextX, now.dist+1));
                    }
                }
            }
        }
        return -1;        
    }
}