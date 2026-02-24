import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] d = new int[N+2];
        int[] t = new int[N+1];
        int[] p = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
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