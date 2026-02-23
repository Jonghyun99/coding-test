import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    //     시간제한 2초

    // N = 7
    // int D = new int[7]

    // D[상담일수] = 이익
    // D[1] 일 경우 인덱스에 T1을, 값에는 P1을더한다
    // D[1+t1]일 경우 더한다..

    // 만약 인덱스 + Ti가 N+1을 넘으면 취소된다.
    // 이 때의 P 값을 minVal에 저장한다.

    // 이제 D가 2로 시작할 경우로 반복
    // 이 때 반복은 1일차 + T1까지


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] timeArray = new int[N+1];
        int[] priceArray = new int[N+1];
        int[] dp = new int[N+2];    // 얘만 + 2인 이유가? (오늘, 0일도 포함이라 그런가?)

        for(int i=1; i<=N; i++) {
            timeArray[i] = sc.nextInt();
            priceArray[i] = sc.nextInt();
        }

        for(int i=N; i>0; i--) {
            if(i+timeArray[i] > N+1) {
                dp[i] = dp[i+1]; // 시간이 초과된다면, 다음날도 같은 수익? 그러면 dp[i+1] = dp[i]가 맞지 않나, 무슨 식이지
            } else {
                dp[i] = Math.max(dp[i+1], priceArray[i] + dp[i+timeArray[i]]);    // 이해가안됨
            }
        }
        System.out.println(dp[1]); // 왜 dp1이지? N이아닌건가

    }
}