    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.StringTokenizer;


    public class Main {
        static final int MOD = 10007;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();

            if(n==k || k==0) {
                System.out.println(1%MOD); return;
            }

            int[][] d = new int[n+1][n+1];
            for(int i=1; i<=n; i++){
                d[i][0] = 1;
                d[i][i] = 1;
            }

            for(int i=2; i<=n; i++){
                for(int j=1; j<i; j++){
                    d[i][j] = (d[i-1][j] + d[i-1][j-1]) % 10007;
                }
            }
            System.out.println(d[n][k]);
        }
    }