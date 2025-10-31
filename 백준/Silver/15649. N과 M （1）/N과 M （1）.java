

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



public class Main{

    static boolean[] visited;
    static int N, M;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1부터~ N까지의 자연수 
        N = Integer.parseInt(st.nextToken());
        // 수열 길이
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        S = new int[M];

        backtracking(0);
        
    }

    static void backtracking(int length){
        if(length==M) {
            for(int i=0; i<M; i++){
                System.out.print(S[i] + 1 + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                S[length] = i;
                backtracking(length+1);
                visited[i] = false;
            }
        }
        
    }

 
    
}
