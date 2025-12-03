import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

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

    static void DFS(int Node){
        visited[Node] = true;
        System.out.print(Node + " ");

        for(int n:adjList.get(Node)){
            if(!visited[n]){
                DFS(n);
            }
        }
    }

    static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Node);
        visited[Node] = true;
        
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            System.out.print(nowNode+" ");
            for(int i:adjList.get(nowNode)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
    }


}
