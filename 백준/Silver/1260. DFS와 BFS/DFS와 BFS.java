import java.io.*;
import java.util.*;


public class Main{

    static int N;
    static int M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();

        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }
        for(int i=0; i<=N; i++){
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
    }

    static void DFS(int node){
        visited[node] = true;
        System.out.print(node + " ");
        for(int num:adjList.get(node)){
            if(!visited[num]){
                DFS(num);
            }
        }
    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now +" ");
            for(int num:adjList.get(now)){
                if(!visited[num]){
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }
    }
        
}
