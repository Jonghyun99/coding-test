import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int GCD = getGCD(A, B);
            int LCM = A*B/GCD;
            System.out.println(LCM);

        }
    }

    static int getGCD(int A, int B) {
        int temp = 0;
        while(B!=0){
            temp = A%B;
            A = B;
            B = temp;
        }
        return A;
    }

}