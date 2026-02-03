import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[10000000+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=10000000; i++) {
            if(isPrime[i]){
                for(int j=i*i; j<=10000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=N; i<=10000000; i++){
            if(isPrime[i]) {
                if(isPalindromeNumber(i)){
                    System.out.println(i);
                    break;
                }
            }
        }

        
    }

    static boolean isPalindromeNumber(int num) {
        int reversed = 0;
        int original = num;
        while(num>0) {
            reversed = reversed * 10 + (num%10);
            num/=10;
        }

        return original == reversed;
    }
}