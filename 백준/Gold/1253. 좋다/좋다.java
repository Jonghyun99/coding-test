import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int answer = 0;
        for(int k = 0; k<N; k++) {
            int sP = 0;
            int eP = N-1;
            long find = A[k];
            while(sP<eP){
                if(A[sP] + A[eP] == find) {
                    if(sP != k && eP != k) {
                        answer++;
                        break;
                    } else if(sP==k){
                        sP++;
                    } else if(eP==k){
                        eP--;
                    }
                } else if(A[sP] + A[eP] > find) {
                    eP--;
                } else {
                    sP++;
                }
            }
        }
        System.out.println(answer);
        
    }
       
}
