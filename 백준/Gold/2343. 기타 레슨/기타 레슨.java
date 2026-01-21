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
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
                if(start < A[i]) start = A[i];
                end += A[i];
            }

            while(start <= end){
                int count = 0;
                int sum = 0;
                int middle = (start+end)/2;

                for(int i=0; i<N; i++){
                    // 블루레이 용량 최소 값 찾기
                    if(sum + A[i] > middle) {
                        count++;
                        sum = 0;
                    }
                    sum += A[i];
                }
                if(sum!=0) count++;

                // start가 커지면, middle이 커져서 count 값이 작아짐
                if(count>M)
                    start = middle + 1;
                else 
                    end = middle - 1;
            }
            System.out.println(start);
        }
    }