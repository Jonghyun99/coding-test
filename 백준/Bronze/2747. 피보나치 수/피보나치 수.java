import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new int[N+1];
        for(int i=0; i<=N; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;

        // 바텀업 방식
        for(int i=2; i<=N; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        // 탑다운 방식
        // fibo(N);


        System.out.println(D[N]);
    }

    static int fibo(int N){
        if(D[N] != -1) return D[N]; // DP의 장점, 기존에 있는 해답은 추가적인 연산 없이 반환 가능
        return D[N] = fibo(N-2) + fibo(N-1); 
    }
}