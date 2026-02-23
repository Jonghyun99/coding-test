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
        
        // N이 1일경우, 1 (0으로 시작할 수 없음) 0: 0, 1:1
        // N이 2일경우, 10 (11이 될 수 없음) 0:1, 1: 0
        // N이 3일경우, 100, 101         0:1, 1:1
        // N이 4일경우, 1000, 1010, 1001    0:2, 1:1
        // N이 5일경우, 10000, 10100, 10101, 10010, 10001 0:3, 1:2
        // N이 6일경우, 100000, 101000, 101010, 101001, 100100, 100101, 100010, 100001 0:5, 3
        // 끝자리가 0인 경우에, 1, 0 둘다 추가
        // 끝자리가 1인 경우에, 0만 추가
        // 따라서, 끝자리가 0인 경우, 이 땐 끝자리가 0과 1일 때 둘다 0이 붙으므로) dp[i][0] = dp[i-1][0] + dp[i-1][1] (모든 경우에서 붙일 수 있으므로)
        // 끝자리가 1인경우, 끝자리가 0인경우에만 붙일 수 있으므로 dp[i][1] = dp[i-1][0]

        long[][] dp = new long[N+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][0] + dp[N][1]);




    }
}