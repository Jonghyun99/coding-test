import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
       Scanner sc = new Scanner(System.in);
       // 1. N 재료의 개수, M 필요한 합
       // 2. 배열을 받는다.
       // 3. 순환하며 합이 M이 되면 count++
       // * 각 원소는 고유한 값을 갖고 있으므로 한번 사용되면 두번은 사용될 수 없다.
       int N = sc.nextInt();
       int M = sc.nextInt();
        int answer = 0;
       int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            if(A[i]!=-1){
                for(int j=i+1; j<N; j++) {
                    if(A[j]!=-1){
                    if(A[i]+A[j] == M) {
                        answer++;
                        A[i]=-1;
                        A[j]=-1;
                        break;
                    }
                    }
                }
            }
        }
        System.out.println(answer);
    }
       
}
