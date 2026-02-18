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

        bfs(1);

        for(int i=2; i<=N; i++)
        System.out.println(parent[i]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next:adj[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = now; // 핵심
                    q.add(next);
                }
            }
        }
    }
}