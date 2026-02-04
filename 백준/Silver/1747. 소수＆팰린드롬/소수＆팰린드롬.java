import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();    
        boolean[] isPrime = new boolean[2000001];
        
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        int sqrtB = (int)Math.sqrt(2000000);
        for(int i=2; i<=sqrtB; i++){
            if(isPrime[i]) {
                for(int j=i*i; j<=2000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=A; i<=2000000; i++) {
            if(isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }

        

    }

    static boolean isPalindrome(int num) {
        int temp = num;
        int checkNum = 0;
        while(temp>0){
            checkNum = (checkNum*10) + temp%10;
            temp /= 10;
        }
        if(checkNum==num) {
            return true;
        } else {
            return false;
        }
    }
}