import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] A = new int[str.length()];
        int idx=0;
        for(char c:str.toCharArray()){
            A[idx++]=c-'0';
        }
        for(int i=0; i<A.length-1; i++) {
            int max = i;
            for(int j=i+1; j<A.length; j++) {
                if(A[j] > A[max]){
                    max = j;
                }
                if(A[i] < A[max]){
                    int temp = A[i];
                    A[i] = A[max];
                    A[max] = temp;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<str.length(); i++) {
            bw.append(A[i]+"");
        }
        bw.flush();
        bw.close();
    }

}

