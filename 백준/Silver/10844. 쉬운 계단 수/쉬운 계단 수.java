        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.StringTokenizer;

        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                long[][] D = new long[N+1][10];
                long mod = 1000000000;

                // D[i][j] = i길이의 숫자에서 j로 끝날 수 있는 경우의수
                for(int i=1; i<=9; i++) {
                    D[1][i] = 1;
                }

                for(int i=2; i<=N; i++){
                    for(int j=0; j<=9; j++){
                        if(j==0) D[i][j] = D[i-1][1];// 끝자리가 0이 될 수 있는 경우의수는 1인 경우
                        else if(j==9) D[i][j] = D[i-1][8];
                        else {
                            D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % mod;
                        }
                    }
                }

                long sum = 0;
                for(int i=0; i<=9; i++){
                    sum = (sum + D[N][i]) % mod;
                }
                System.out.println(sum);

            }
        }