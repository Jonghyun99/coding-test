import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int answer = 0;
        for(int k=0; k<N; k++){
            int find = A[k];
            int i = 0;
            int j = N-1;
            while(i<j) {
                if(A[i] + A[j] == find) {
                    if(i != k && j != k) {
                        answer++;
                        break;
                    } else if(i==k) {
                        i++;
                    } else if(j==k){
                        j--;
                    }
                } else if(A[i] + A[j] > find) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        System.out.println(answer);

    }
       
}
