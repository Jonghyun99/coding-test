import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Main{
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean check;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList();
        for(int i=0; i<N; i++){
            adjList.add(new ArrayList<Integer>());
        }
        visited = new boolean[N];

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        check = false;
        // DFS 로직 실행
        for(int i=0; i<N; i++){
            DFS(i,0);
        }
        
        if(check){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void DFS(int v, int cnt) {
        if(cnt>=4) {
            check = true;
            return;
        }

        visited[v] = true;
        
        for(int u:adjList.get(v)){
            if(!visited[u]){
                DFS(u,cnt+1);
            }

            if(check) return;
        }
        visited[v] = false;
    }


}
