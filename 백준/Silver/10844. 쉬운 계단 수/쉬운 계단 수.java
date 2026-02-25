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
                long mod = 1000000000;

                // prev[i], cur[i] 끝자리가 i인 값의 경우의수
                long[] prev = new long[10];
                long[] cur = new long[10];

                for(int i=1; i<=9; i++) {
                    prev[i] = 1;
                }

                for(int i=2; i<=N; i++){
                    cur[0] = prev[1] % mod;
                    cur[9] = prev[8] % mod;
                    for(int j=1; j<=8; j++){
                        cur[j] = (prev[j-1] + prev[j+1]) % mod;
                        // 이부분 (prev[j-1] % mod + prev[j+1] % mod) % mod 랑
                        // (prev[j-1] % mod + prev[j+1] % mod) 이거랑, 3개다 똑같은 결과지? 밑에껀 다른가
                    }
                    for(int j=0;j<=9; j++){
                        prev[j] = cur[j];
                    }
                }

                long sum = 0;
                for(int i=0; i<=9; i++){
                    sum = (sum + prev[i]) % mod;
                }
                System.out.println(sum);

            }
        }