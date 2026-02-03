import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 에라토노스의체 
        // n부터 m까지 본인을 제외한 배수를 제거하며 소수를 판별한다.
        boolean[] A = new boolean[M+1];
        Arrays.fill(A, true);

        A[0] = false;
        A[1] = false;
        
        //소수 판별
        for(int i=2; i<=Math.sqrt(M); i++) {
            if(!A[i]) continue;
            
            // i의 배수 반복문 
            for(int j=i+i; j<=M; j=j+i) {
                A[j] = false;
            }
        }

        for(int i=N; i<=M; i++) {
            if(A[i]) System.out.println(i);
        }
    }
}