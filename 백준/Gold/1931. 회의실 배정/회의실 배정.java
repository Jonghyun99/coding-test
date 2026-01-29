import java.util.*;
import java.io.*;

class Main {

    // 1. 입력과 자료구조

    // 2. 로직흐름

    // 3. 예외 케이스 몰라서 스킵
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A,(o1,o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int count  = 0;
        int end = -1;
        for(int i=0; i<N; i++) {
            if(A[i][0] >= end) {
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
