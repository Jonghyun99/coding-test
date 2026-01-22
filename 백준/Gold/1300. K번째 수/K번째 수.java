    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            long start = 1;
            long end = K;
            
            long ans = 0;
            while(start<=end){
                long cnt = 0;
                long middle = (start + end)/2;

                for(int i=1;i<=N; i++){
                    cnt+=Math.min(middle/i,N);
                }

                if(cnt<K){
                    start = middle+1;
                } else {
                    end = middle-1;
                    ans = middle;
                }
            }
            System.out.println(ans);
        }
    }