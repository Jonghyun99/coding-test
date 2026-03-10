import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int N,M;
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }
    static void dfs(int node) {
        visited[node] = true;
        for(int next:adjList[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}