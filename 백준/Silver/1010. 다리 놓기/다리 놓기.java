import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        int[][] dp = new int[30][30];
        for(int i=1; i<30; i++){
            dp[i][0]=1;
            dp[i][i]=1;
        }

        for(int i=2;i<30; i++){
            for(int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q>0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(dp[M][N]);
            q--;
        }
    }
}