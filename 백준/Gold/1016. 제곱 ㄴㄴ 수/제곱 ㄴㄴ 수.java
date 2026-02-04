import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        boolean[] check = new boolean[(int)(Max-Min+1)];
        for(long i=2; i*i<=Max; i++){
            long square = i*i;

            // 이게뭐야 
            // min보다 크거나 같은 수 중에서, square의 배수 중 가장 작은 수 찾기
            // 왜 이 식임?
            long start = Min / square;
            if(Min%square!=0) {
                start++;
            }

            // 이제 start는 min이상 수중 몇번째 square의 배수인지를 의미
            start *= square;

            for(long j=start; j<=Max; j+=square) {
                check[(int)(j-Min)] = true;
            }

            
            
        }
        int count = 0;
        for(int i=0; i<check.length; i++){
            if(!check[i]){
                count++;
            };
        }
        System.out.println(count);
    }
}