
import java.io.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
            if(A[i] > max){
                max = A[i];
            }
        }

        radixSort(A, max);
        for(int i=0;i<N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] A, int max){
        int exp = 1;
        int[] output = new int[A.length];
        while(max/exp > 0) {
            int[] count = new int[10];

            for(int i=0; i<A.length; i++){
                count[(A[i]/exp)%10]++;
            }

            for(int i=1; i<10; i++){
                count[i] += count[i-1];
            }

            for(int i=A.length-1; i>=0; i--){
                // count[i]의 누적합 값을  out
                int digit = (A[i]/exp)%10;
                output[count[digit]-1] = A[i];
                count[digit]--;
            }

            for(int i=0; i<A.length; i++){
                A[i] = output[i];
            }
            exp*=10;
        }
    }

    
       
}