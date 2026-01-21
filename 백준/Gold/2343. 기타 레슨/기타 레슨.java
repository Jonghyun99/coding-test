    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());

            int start = 0;
            int end = 0;

            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                if(A[i]> start) start = A[i];
                end += A[i];
            }

            while(start<=end){
                int middle = (start + end) / 2;
                int sum = 0;
                int count = 0;

                for(int i=0; i<N; i++){
                    if(sum+A[i] > middle) {
                        count++;
                        sum = 0;
                    }
                    sum+=A[i];
                }
                if(sum!=0) count++;
                if(count>M) {
                    start = middle+1;
                } else {
                    end = middle - 1;
                }
            }
            System.out.println(start);
        }
    }