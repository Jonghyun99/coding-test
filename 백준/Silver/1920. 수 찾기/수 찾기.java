import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<D; i++){
            boolean flag = false;
             int target = Integer.parseInt(st.nextToken());
             int start = 0;
             int end = N-1;
             while(start<=end){
                int mid = (end+start)/2;
                if(A[mid]>target) {
                    end = mid-1;
                } else if(A[mid]<target) {
                    start = mid+1;
                } else {
                    flag = true;
                    break;
                }
             }
             if(flag) {
                 System.out.println(1);
             } else {
                System.out.println(0);
             }
        }
    }
}

