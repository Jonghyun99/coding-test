    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.StringTokenizer;


    public class Main {
        static int[][] D;
        static long N, K;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            K = sc.nextInt();
            // D = new int[N+1][N+1];
            // for(int i=0; i<=N; i++) {


            long result = 1;
            for(int i = 1; i<=K; i++) {
                result *= N;
                result /= i;
                N--;
            }
            System.out.println(result);

        }

        // D[i][j] = D[i-1][j] (특정 숫자 하나를 뽑지않았을 때) + D[i-1][j-1] (특정 숫자 하나를 뽑았을 때)
        // static int getCase(int N, int K){
            
        // }
    }