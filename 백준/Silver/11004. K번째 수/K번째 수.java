import java.util.*;
import java.io.*;

public class Main {

  

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int start, int end, int k){
        if(start<end){
            int pivot = partition(A, start, end);
            if(pivot == k) {
                return;
            } else if (k < pivot) {
                quickSort(A, start, pivot-1,k);
            } else {
                quickSort(A, pivot+1, end,k);
            }
        }
    }

    public static int partition(int[] A, int s, int e){
        if(s+1 == e) {
            if(A[s] > A[e]) swap(A,s,e);
            return e;
        }

        int m = (s+e)/2;
        swap(A, s, m);
        int pivot = A[s];
        int i = s+1;
        int j = e;

        while(i<=j){
            while(j >= s+1 && pivot<A[j]) {
                j--;
            }
            while(i<=e && pivot>A[i]) {
                i++;
            }
            if(i<=j){
                swap(A,i++,j--);
            }
        }
        A[s] = A[j];
        A[j] = pivot;
        return j;
    }
       
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

       

}

