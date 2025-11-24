import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        int start = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(adjList.get(i));
        }
        dfs(start);
        System.out.println();
        visited = new boolean[N+1];
        bfs(start);
        System.out.println();
        
    }

    static void dfs(int u) {
        System.out.print(u + " ");
        visited[u] = true;
        for(int v:adjList.get(u)){
            if(!visited[v]){
                dfs(v);    
            }
        }
    }

    static void bfs(int u){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(u);
        visited[u] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode + " ");
            for(int i:adjList.get(nowNode)){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }

            }

        }
    }
}
