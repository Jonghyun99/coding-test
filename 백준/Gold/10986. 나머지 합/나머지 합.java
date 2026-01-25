    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long cnt = 0;
            int sum = 0;
            long[] C = new long[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                sum = (sum + Integer.parseInt(st.nextToken())) % M;
                if(sum == 0) cnt++;

                C[sum]++;
            }

            for(int i=0; i<M; i++) {
                cnt += C[i] * (C[i]-1) / 2;
            }

            System.out.println(cnt);
            

        }
    }