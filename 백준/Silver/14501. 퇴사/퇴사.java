import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int maxprofit, N;
    static int[] t,p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        t = new int[N+1];
        p = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(maxprofit);
        
    }

    static void dfs(int day, int profit) {
        if(day>N+1) return;

        if(day<=N+1) {
            maxprofit = Math.max(profit,maxprofit);
        }

        if(day== N+1) return;


        dfs(day + t[day], profit+p[day]);

        dfs(day+1, profit);

    }
}