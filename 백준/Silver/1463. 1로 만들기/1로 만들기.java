import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] D;
    static int N;
    // 1. X가 3으로 나누어떨어지면 3으로 나눈다.
    // 2. X가 2로 나누어 떨어지면 2로 나눈다.
    // 3. 1을 뺀다.
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        D = new int[N+1];
        D[1] = 0;
        for(int i=2; i<=N; i++) {
            D[i] = D[i-1] + 1;
            if(i%2==0) D[i] = Math.min(D[i], D[i/2]+1); 
            if(i%3==0) D[i] = Math.min(D[i], D[i/3]+1); 
        }
        System.out.println(D[N]);
    }
}