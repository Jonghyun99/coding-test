    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            long start = 1, end = K;
            long ans = 0;

            while(start<=end) {
                long middle = (start + end) / 2;
                long cnt = 0;

                // 중앙 값보다 작은 수 몇개인지 계산하기 (1. 왜 N이랑 비교하는지?)
                for(int i=1; i<=N; i++){
                    cnt += Math.min(middle / i,N);  // 핵심로직
                }
                if(cnt<K) {
                    start = middle + 1;
                } else {
                    ans = middle;
                    end = middle - 1;
                }
            }
            System.out.println(ans);
        }
    }