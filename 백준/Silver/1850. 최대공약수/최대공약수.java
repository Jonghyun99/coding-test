import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long result = gcd(A,B);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<result; i++){
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    static long gcd(long a, long b){
        while(b>0){
            long temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
        
}