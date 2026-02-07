import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long gcb = getGCB(A, B);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<gcb; i++){
            sb.append(1);
        }
        System.out.println(sb);


    }

    static long getGCB(long A, long B) {
        while(B>0) {
            long temp = A%B;
            A = B;
            B =  temp;
        }
        return A;
    }
}