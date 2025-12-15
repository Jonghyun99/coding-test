import java.util.*;
import java.io.*;

class Main{

    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());     
        int N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            // 이진탐색시작
            int start = 0;
            int end = A.length-1;
            while(start<=end) {
                int midi = (start + end) / 2;
                int midV = A[midi];
                if(midV > target) {
                    end = midi - 1;
                } else if (midV < target) {
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                } 
            }
            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

