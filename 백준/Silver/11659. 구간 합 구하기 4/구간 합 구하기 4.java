import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCount = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());
        int[] sumArray = new int[numCount+1];
        st = new StringTokenizer(br.readLine());
        sumArray[0]=0;
        for(int i=1; i<=numCount;i++){
            sumArray[i] = sumArray[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int idx=0; idx<queryCount; idx++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sumArray[j] - sumArray[i-1]);
        }
    }
}