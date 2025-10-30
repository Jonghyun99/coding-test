
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;



public class Main{
    
    static int N;
    static Deque<State> stack;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stack = new ArrayDeque<>();
        stack.push(new State(7,1));
        stack.push(new State(5,1));
        stack.push(new State(3,1));
        stack.push(new State(2,1));
        DFS(stack);
    }
    
    static void DFS(Deque<State> stack) {
        while(!stack.isEmpty()){
            State current = stack.pop();
            int number = current.number;
            int digit = current.digit;

            if(digit == N){
                if(isPrime(number)) {
                    System.out.println(number);
                    continue;
                }
            }
            
            for(int i=9; i>=1; i-=2){
                if(isPrime(number*10+i)){
                    // DFS(number*10+i,digit+1);
                    stack.push(new State(number*10+i,digit+1));
                }
            }
        }
    }

    static boolean isPrime(int number){
        if(number < 2) return false;

        for(int i=2; i*i <= number; i++){
            if(number%i==0) return false;
        }

        return true;
    }   
}
class State{
    int number;
    int digit;

    public State(int number, int digit){
        this.number = number;
        this.digit = digit;
    }
}