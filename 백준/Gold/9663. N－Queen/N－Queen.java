import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }

    static void backtracking(int row) {
        if(row==N) {
            cnt++;
            return;
        }
        for(int i=0; i<N; i++){
            A[row] = i;
            if(check(row)){
                backtracking(row+1);
            }
        }
    }

    static boolean check(int row){
        for(int i=0; i<row; i++){
            if(A[i] == A[row]) return false;
            
            // 여기가 중요, 인덱스의 차이와 배치된 칸의 차이가 같을 경우 대각선에 존재함
            if(Math.abs(row-i) == Math.abs(A[i] - A[row])) return false; // 대각선에 있는지 체크
        }

        return true;
    }

}