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
        int size = Integer.parseInt(br.readLine());

        dist = new int[size + 1][size + 1];

        StringTokenizer st;
        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    // 이 부분만 해결하면 된다.
                    // 각 노드 간 연결이 되어 있는지 확인하여야 함
                    // 기존에는 각 노드 간의 최단거리를 구하여 행렬에 대입하였으나
                    // 이번에는 각 노드 간 연결 여부만 구하여 행렬에 대입하면 됨
                    // 따라서 Math.min과 dist[i][k] + dist[k][j] 등이 아니라.. 점화식을 세워야함
                    // 우선 i와 j가 연결되어있는지 알려면 어떻게 해야할까?
                    // 1. dist[i][j]를 확인한다.
                    // ex) dist[1][1]은 0이지만
                    // dist[1][2] = 1, dist[2][3] = 1, dist[3][1] = 1이므로 dist 1->1도 1이라 할 수 있다.
                    // *길이 없는 경우만 0을 넣으면 된다. 

                    // 모르겠다, 근데 왜 [i][k]랑 [k][j]를 더하는데 .. 아 경유지
                
                    // if (dist[i][k] + dist[k][j] >= 1)
                        // dist[i][j] = 1;
                    if(dist[i][k] ==1 && dist[k][j] ==1) {
                        dist[i][j] = 1;
                    }
                    // dist[i][j] = Math.max(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}