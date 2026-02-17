import java.io.*;
import java.util.*;

public class Main{

    static int INF = 987654321;
    static int[][] dist;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // 왜 bfs는 메소드를 분리하는데 플로이드 워셜은 분리안할까?
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minSum = INF;
        int resultPerson = -1;

        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++) {
                sum += dist[i][j];
            }
            if(minSum>sum) {
                minSum = sum;
                resultPerson = i;
            }
        }

        System.out.println(resultPerson);



    }
}
