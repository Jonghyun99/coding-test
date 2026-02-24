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

        int[] d = new int[N+2];
        int[] t = new int[N+1];
        int[] p = new int[N+1];

        for(int i=1; i<=N; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++) {
            d[i+1] = Math.max(d[i], d[i+1]);

            int payDay = t[i]+i;
            if(payDay<=N+1) {
                d[payDay] = Math.max(d[payDay], d[i] + p[i]);
            }
        }
        System.out.println(d[N+1]);
        
    }
}