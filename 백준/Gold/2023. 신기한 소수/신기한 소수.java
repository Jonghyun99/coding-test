

import java.io.*;
import java.util.StringTokenizer;



public class Main{

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int number, int exp){
        if(exp==N) System.out.println(number);

        for(int i=1; i<=9; i+=2){
            if(isPrime(number*10+i)){
                DFS(number*10+i,exp+1);
                if(exp==N) return;
            }
        }
    }

    static boolean isPrime(int number){
        if(number<2) return false;

        // 범위 = 맞는지 확인
        for(int i=2;i*i<=number;i++){
            if(number%i==0) return false;
        }
        return true;

    }

    
}
