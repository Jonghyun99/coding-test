import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N+1];
        
        switch (N) {
            case 0:
                System.out.println(0);
                return;
            case 1:
                System.out.println(1);
                return;
        }

        A[0] = 0;
        A[1] = 1;
        fibo(2);
        System.out.println(A[N]);
    }

    // 0,1,1,2,3,5,8,13,21
    static int fibo(int i) {
        if(i==N) return A[i] = A[i-1] + A[i-2];
        A[i] = A[i-1] + A[i-2];
        return fibo(i+1);
    }
}