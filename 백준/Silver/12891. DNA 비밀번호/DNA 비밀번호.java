
import java.util.*;
import java.io.*;

public class Main {

    static int IDX_A = 0;
    static int IDX_C = 1;
    static int IDX_G = 2;
    static int IDX_T = 3;
    
    static int[] currentArry = new int[4];
    static int[] checkArray = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이

        char[] A = new char[S];
        A = br.readLine().toCharArray();    // 문자열 배열

        int secretCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
            if(checkArray[i] == 0)  secretCount++;
        }

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int idx = charToIdx(A[i]);
            if(idx != -1) {
                currentArry[idx]++;
                if(currentArry[idx]==checkArray[idx]) {
                    secretCount++;
                }
            }
        }
        if(secretCount == 4) {
            answer++;
        }

        for (int i = P; i<S; i++){
            int j = i-P;
            int start = charToIdx(A[j]);
            int end = charToIdx(A[i]);
            if(end != -1) {
                currentArry[end]++;
                if(currentArry[end] == checkArray[end]){
                    secretCount++;
                }
            }
            if(start != -1){
                if(currentArry[start] == checkArray[start]){
                    secretCount--;
                }
                currentArry[start]--;
            }
            if(secretCount==4) answer++;
        }
        System.out.println(answer);
    }

    static private int charToIdx(char c) {
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

}
