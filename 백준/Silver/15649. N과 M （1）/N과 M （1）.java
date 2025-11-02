
import java.io.*;
import java.util.StringTokenizer;



public class Main{

    static int N,M;
    static boolean[] visited;
    static int[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        S = new int[M];

        DFS(0);
        System.out.println(sb.toString());
        
    }

    static void DFS(int length){
        if(length == M){
            for(int i=0; i<M; i++){
                sb.append(S[i] + 1 + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                S[length] = i;
                DFS(length+1);
                visited[i]=false;
            }
        }
      
    }


    

 
    
}
