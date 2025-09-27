import java.util.*;
import java.io.*;

public class Main {
    private static final int IDX_A = 0;
    private static final int IDX_C = 1;
    private static final int IDX_G = 2;
    private static final int IDX_T = 3;

    private static int secretCount = 0;

    static final int[] currentArray = new int[4];
    static final int[] checkArray = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이

        char[] A = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            checkArray[i] = Integer.parseInt(st.nextToken());
            if(checkArray[i] == 0) secretCount++;
        }

        for(int i=0; i<P; i++){
            add(A[i]);
        }
        
        int answer = 0;
        if(secretCount==4) answer++;
        
        for(int i=P; i<S; i++){
            int j=i-P;
            
            add(A[i]);
            remove(A[j]);

            if(secretCount==4) answer++;
        }
        System.out.println(answer);

    }

    private static int charToIndex(char c){
        switch (c) {
            case 'A':
                return IDX_A;
            case 'C':
                return IDX_C;
            case 'G':
                return IDX_G;
            case 'T':
                return IDX_T;
            default:
                return -1;
        }
    }

    static private void add(char c) {
        int idx = charToIndex(c);
        if(idx!=-1) {
            currentArray[idx]++;
            if(currentArray[idx]==checkArray[idx]) {
                secretCount++;
            }
        }
    }
    static private void remove(char c) {
        int idx = charToIndex(c);
        if(idx!=-1) {
            if(currentArray[idx]==checkArray[idx]) {
                secretCount--;
            }
            currentArray[idx]--;
        }
    }

}
