import java.io.*;
import java.util.StringTokenizer;


public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        long[] remainder = new long[M];
        long currentSum = 0;
        long answer = 0;
        remainder[0] = 1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            currentSum = (currentSum + Integer.parseInt(st.nextToken()))%M;
            remainder[(int)currentSum]++;
        }

        for(int i=0; i<M; i++){
            long count = remainder[i];
            answer += count*(count-1)/2;
        }
        System.out.println(answer);
    }

}
