    import java.util.*;
    import java.io.*;

class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0,0);
        System.out.println(map[N-1][M-1]);
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i=0; i<4; i++){
                int nX = nowX + dx[i];
                int nY = nowY + dy[i];
                if(nX>=N || nX<0 || nY>=M || nY<0) continue;
                if(map[nX][nY] == 0 || visited[nX][nY] == true) continue;
                queue.offer(new int[] {nX,nY});
                visited[nX][nY] = true;
                map[nX][nY] = map[nowX][nowY] + 1;
            }
        }
    }
}
