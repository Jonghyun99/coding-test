

import java.io.*;
import java.util.Scanner;

public class Main{

    static int N;
    static int[] A;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }

    static void backtracking(int row) {
        if(row == N) {
            cnt++;
            return;
        }
        for (int i=0; i<N; i++){
            A[row] = i;
            if(check(row)) {
                backtracking(row+1);
            }
        }
    }

    static boolean check(int row) {
        for(int i=0; i< row; i++){
            if(A[i] == A[row]) return false; //일직선인 경우
            if(Math.abs(row-i) == Math.abs(A[i] - A[row])) return false; // 대각선인 경우
        }
        return true;
    }




    

 
    
}
