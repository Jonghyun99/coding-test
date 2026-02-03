import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] isPrime = new boolean[M+1];
        Arrays.fill(isPrime,true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=M; i++){
            if(isPrime[i]) {
                for(int j=i*i; j<=M; j=j+i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=N; i<=M; i++){
            if(isPrime[i]) {
                sb.append(i);
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}