    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int start = 0;
            int end = A.length-1;
            int cnt = 0;
            int sum = A[start] + A[end];

            while(start<end){
                if(sum == M) {
                    end--;
                    start++;
                    sum = A[start] + A[end];
                    cnt++;
                } else if (sum > M) {
                    sum-=A[end];
                    end--;
                    sum+=A[end];
                } else {
                    sum-=A[start];
                    start++;
                    sum+=A[start];
                }
            }
            System.out.println(cnt);
        }
    }