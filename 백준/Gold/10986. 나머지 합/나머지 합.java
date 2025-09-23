import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M =sc.nextInt();
        
        int[] S = new int[N+1];
        int[] C = new int[M];

        for(int i=1; i<=N; i++){
            S[i] = (S[i-1] + sc.nextInt()) % M;
        }
        
        long answer = 0;
        for(int i=1; i<=N; i++){
            if(S[i]==0) answer++;
            C[S[i]]++;
        }

        for(int i=0; i<M; i++) {
            if(C[i]>1){
                answer += (long)C[i]*(C[i]-1)/2;
            }
        }
        System.out.println(answer);
    }   
}