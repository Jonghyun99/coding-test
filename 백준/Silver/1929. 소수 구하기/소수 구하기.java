import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] isPrime = new boolean[M+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // 약수대칭성, i의 제곱이 M보다 커지면 더이상 i로 떨어지는 M의 약수는 없음
        for(int i=2; i*i<=M; i++){

            // i가 소수라면 i의 배수 지우기
            if(isPrime[i]) {
                // j= i*2가 아닌 i*i부터 시작해도 됨
                // 왜나하면  i의 2,3,4.. i-1들은 i까지의 반복문에서 이미 지워짐 
                for(int j=i*i; j<=M; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=N; i<=M; i++){
            if(isPrime[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}