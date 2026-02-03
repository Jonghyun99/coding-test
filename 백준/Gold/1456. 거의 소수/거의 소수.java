import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int limit = (int)Math.sqrt(B);

        boolean[] isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<=Math.sqrt(limit); i++) {
            if(isPrime[i]){
                for(int j=i*i; j<=limit; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        long cnt = 0;
        for(int i=2; i<=limit; i++) {
            if(isPrime[i]){
                long temp=i;
                while(temp<=B/i) {
                    temp*=i;
                    if(temp>=A){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}