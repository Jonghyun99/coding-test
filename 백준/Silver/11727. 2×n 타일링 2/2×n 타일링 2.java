import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[1001];
        D[1] = 1;
        D[2] = 3;

        for(int i=3; i<=N; i++) {
            D[i] = (D[i-1] + D[i-2] + D[i-2]) % 10007;
        }
        System.out.println(D[N]);

    }
}