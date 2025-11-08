
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    static void dfs(int num, int length){
        if(length == N) {
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }

        for(int i=1; i<=9; i+=2){
            if(isPrime(num*10+i)){
                dfs(num*10+i,length+1);
            }
        }
    }

    static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
