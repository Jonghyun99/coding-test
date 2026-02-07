import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 미로의 최단 거리를 찾아내자 -> BFS 사용
    // 시간제한 1초, 미로의너비(N*M) 2<=N,M<=100
    // BFS쓰면 o(nlogn) 맞나?

    // 거리를 어떻게 측정할거야?
    // -> bfs니까 그냥 도착위치(N,M) 도달했을 때의 길이 값 출력하면 되지 않을까?
    // 그러면 map에다가 거리를 1씩 더해서 출력하는거랑 별도로 count하는것도 가능한가? 둘중 어느게 나을까?
    // 일단 별도로 count하는 방식으로 해보자 -> X 흠.. 여러 길을 탐색하면서 진행하다보니 cnt는 안되는거 같네? map마다 위치를 표시하는게 맞는거같다
    // 약간 직관적으로 안와닿고 헷갈리는게, dfs도 걍 미로들 분기마다 파서 길찾는건데
    // bfs는 너비탐색이고,, 근데 어떻게 bfs가 최단거리를 찾게되는거지? 원리가 조금 헷갈리네

    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int N,M;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        map = new int[N][M];
        for(int i=0;i<N; i++){
            String line = br.readLine();
            for(int j=0;j<M; j++){
                int num = line.charAt(j) - '0';
                map[i][j] = num; 
            }
        }
        // System.out.println(map[0][0]);
        visited = new boolean[N][M];
        BFS(0,0);
        System.out.println(map[N-1][M-1]);
    }

    static void BFS(int i, int j) {
        // 제너럴은 wrapper타입만 되는거 아니였나?  원시타입도 되네??
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] nowPoint = q.poll();
            int nowI = nowPoint[0];
            int nowJ = nowPoint[1];
            
            if(nowI == N-1 && nowJ == M-1) {
                return;
            }

            for(int k=0; k<4; k++){
                int x = nowI + dx[k];
                int y = nowJ + dy[k]; 
                
                if(check(x,y)){
                    q.add(new int[] {x,y});
                    visited[x][y] = true;
                    map[x][y] = map[nowI][nowJ] + 1;
                }
            }
        }
    }

    static boolean check(int x, int y){
        if(x<0 || y<0 || x >= N || y >= M) {
            return false;
        }
        if(map[x][y] == 0 || visited[x][y]){
            return false;
        }
        return true;
    }

}