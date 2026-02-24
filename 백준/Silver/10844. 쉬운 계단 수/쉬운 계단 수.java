import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] D = new long[N+1][10];
        
        for(int i=1; i<=9; i++) {
            D[1][i] = 1;
        }
        long mod = 1000000000;

        // d[i][j] = 길이가 i이고, 끝이 j로 끝나는 계단 수의 개수
        for(int i = 2; i<=N; i++) {
            for(int j=0; j<=9; j++){
                if(j==0) {
                    D[i][0] = D[i-1][1] % mod; // 0이 되려면 이전자리가 무조건 1이여야함
                } else if (j==9) {
                    D[i][9] = D[i-1][8] % mod;
                } else {
                    D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % mod;
                }
            }
        }
        long sum = 0;
        for(int i= 0;i<=9; i++){
            sum = (sum + D[N][i]) % mod;
        }
        System.out.println(sum);

    }
}