import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] S = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        
        S[0] = A[0];
        for(int i=1; i<N; i++) {
            S[i] = S[i-1] + A[i];
        }
        int sum =0;
        for(int i=0; i<N; i++) {
            sum+=S[i];
        }
        System.out.println(sum);
    }

}

