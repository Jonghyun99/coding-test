import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1. N 재료의 개수, M 필요한 합
        // 2. 배열을 받는다.
        // 3. 정렬한다.
        // 4. 
        // * 각 원소는 고유한 값을 갖고 있으므로 한번 사용되면 두번은 사용될 수 없다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        
       int N = Integer.parseInt(br.readLine());
       int M = Integer.parseInt(br.readLine());
       int startPointer = 0;
       int endPointer = N-1;
       int answer = 0;
       int[] A = new int[N];
       StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        while(startPointer<endPointer) {
            if(A[startPointer]+A[endPointer]==M){
                answer++;
                startPointer++;
                endPointer--;
            } else if(A[startPointer]+A[endPointer]>M){
                endPointer--;
            } else {
                startPointer++;
            }
        }
        
        System.out.println(answer);
    }
       
}
