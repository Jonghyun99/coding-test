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

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        
        // 트리는 양방향 저장
        for(int i=0; i< N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++)
            sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for(int next:adj[node]) {
            if(!visited[next]) {
                visited[next]= true;
                parent[next] = node; // 핵심
                dfs(next);
            }
        }
    }
}