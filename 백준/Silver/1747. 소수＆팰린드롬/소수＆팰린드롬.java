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

    // 이게 최선일까?
    static boolean isPalindromeNumber(int num) {
        String strNum = String.valueOf(num);
        // string을 한 문자열씩 split할 때 인자는??
        StringBuilder sb = new StringBuilder();
        char[] arr = strNum.toCharArray();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]-'0');
        }
        if(num == Integer.parseInt(sb.toString())) {
            return true;
        }
        return false;
    }
}