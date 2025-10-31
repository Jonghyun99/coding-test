

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

        S = new int[N];
        visited = new boolean[N];
        backtracking(0);

    }

    static void backtracking(int length){
        // 길이 되면 출력 후 종료        
        if(length==M) {
            printArray();
            return;
        }

        // 
        for(int i=0; i<N; i++){
            // 방문하지 않았다면
            if(!visited[i]) {
                visited[i] = true;  // 수 저장하기

                // 수열 정보에 값 추가
                S[length] = i;
                backtracking(length + 1);
                visited[i] = false; // 저장한 수 반납하기
            }
        }
    }

    static void printArray(){
        for (int i= 0; i< M; i++){
            System.out.print(S[i] + 1 + " ");
        }
        System.out.println();
    }
    
}
