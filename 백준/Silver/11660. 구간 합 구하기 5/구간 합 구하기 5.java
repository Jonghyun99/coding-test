import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       
       int[][] aArray = new int[n+1][n+1];
       for (int i = 1; i<=n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j=1; j<=n; j++) {
            aArray[i][j] = Integer.parseInt(st.nextToken());
        }
       }
       int[][] dArray = new int[n+1][n+1];
       for(int i=1; i<=n; i++){   
            for(int j=1; j<=n; j++){
                dArray[i][j] = dArray[i][j-1] + dArray[i-1][j] - dArray[i-1][j-1] + aArray[i][j];
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = dArray[x2][y2] - dArray[x1-1][y2] - dArray[x2][y1-1] + dArray[x1-1][y1-1];
            System.out.println(answer);
        }
    }
}
