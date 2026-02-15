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

    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        // 인접행렬 초기화
        int[][] dist = new int[nodeCnt+1][nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(i==j) {
                    dist[i][j] = 0; // 자기 자신에게 가는 수
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // 간선 정보 입력받기
        StringTokenizer st;
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 기존 노선과 새로운 노선 중 더 싼 비용만 갱신 (중복 노선이 있는건가??)
            dist[from][to] = Math.min(dist[from][to], cost);
        }

        // 핵심로직(점화식)
        for(int k=1; k<=nodeCnt; k++) {
            for(int i=1; i<=nodeCnt; i++){
                for(int j=1; j<=nodeCnt; j++){
                    //이건 무슨 조건문이지?
                        // 이건 무슨식이지?, 원리가 뭐지?
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 결과출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(dist[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}