import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] dist;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        dist = new int[nodeCnt+1][nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++){
            for(int j=1; j<=nodeCnt; j++){
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        StringTokenizer st;
        for(int i=0; i<edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if(dist[from][to] > cost)
            dist[from][to] = cost;
        }

        for(int k=1; k<=nodeCnt; k++){
            for(int i=1; i<=nodeCnt; i++){
                for(int j=1; j<=nodeCnt; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=nodeCnt; i++){
            for(int j=1; j<=nodeCnt; j++){
                if(dist[i][j] == INF) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}