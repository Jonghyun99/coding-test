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

        long[] D = new long[N+1];
        D[0] = 0;
        D[1] = 1;
        for(int i=2; i<=N; i++){
            D[i] = D[i-1] + D[i-2];
        }
        System.out.println(D[N]);
        
    }
}