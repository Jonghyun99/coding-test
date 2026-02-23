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
        int[] dp = new int[46];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<46; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);

    }
}