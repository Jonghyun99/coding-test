    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.StringTokenizer;


    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            if(N==K || K==0) {
                System.out.println(1);
                return;
            }

            int[][] dp = new int[N+1][N+1];

            // nc0 = 1, ncn = 1
            for(int i=0; i<=N; i++){
                dp[i][0] = 1;
                dp[i][i] = 1;
            }

            for(int i=2; i<=N; i++){
                for(int j=1; j<i; j++){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    dp[i][j] %= 10007;
                }
            }
            System.out.println(dp[N][K]);
        }
    }