import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rCost = Integer.parseInt(st.nextToken());
            int gCost = Integer.parseInt(st.nextToken());
            int bCost = Integer.parseInt(st.nextToken());

            if(i==0) {
                dp[i][0] = rCost;
                dp[i][1] = gCost;
                dp[i][2] = bCost;
            } else {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rCost;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + gCost;
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + bCost;
            }
        }

        int minCost = Math.min(dp[N-1][0], Math.min(dp[N-1][1],dp[N-1][2]));
        System.out.println(minCost);
    }
}