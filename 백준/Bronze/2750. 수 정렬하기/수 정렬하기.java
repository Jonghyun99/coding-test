import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i=0;i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N; i++){
            sb.append(A[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    

    }

}
