import java.io.*;
import java.util.StringTokenizer;


public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수 (1 <= N <= 10^6)
        int M = Integer.parseInt(st.nextToken()); // 나눌 수 (2 <= M <= 10^3)

        long answer = 0;
        long[] remainderCounts = new long[M];
        int currentSum = 0;

        remainderCounts[0] = 1;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            currentSum = (currentSum + Integer.parseInt(st.nextToken()))%M;
            remainderCounts[currentSum]++;
        }

        for(int r=0; r<M; r++){
            long count = remainderCounts[r];
            if(count>1) {
                answer += count * (count-1) / 2;
            }
        }


        System.out.println(answer);
    }

}
