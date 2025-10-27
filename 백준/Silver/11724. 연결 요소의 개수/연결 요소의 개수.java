

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for (int i=1; i< n+1; i++) {
            if(!visited[i]) {
                count++;
                DFS(A, i);
            }
        }
        System.out.println(count);
    }


    public static void DFS(ArrayList<Integer>[] A, int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for (int i:A[v]) {
            if(visited[i] == false) {
                DFS(A, i);
            }
        }
    }

    
       
}