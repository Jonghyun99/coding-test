
import java.io.*;
import java.util.Scanner;

public class Main{

    static int N;

    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int number, int digit){
        if (digit == N){
            if (isPrime(number)){
                System.out.println(number);
            }
            return;
        }

        for(int i=1; i<10; i++){
            if(i%2==0) continue;
            if(isPrime(number*10 + i)){
                DFS(number * 10 + i, digit + 1);
            }
        }
    }

    static boolean isPrime(int number){
        for (int i=2; i<=Math.sqrt(number); i++)
            if(number%i==0){
                return false;
            }
        return true;
    }
}