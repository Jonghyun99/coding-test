        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.StringTokenizer;

        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] arr = new int[N+1];
                for(int i=0; i<N; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                // dp[i][0]: 수를 제거하지 않은 경우, i를 포함한 연속 합의 최대값
                // dp[i][1]: 수를 1개 제거한 경우, i를 포함한 최대 연속 합
                int[][] dp = new int[N+1][2];
                // 초기화; (i=0일 때)
                dp[0][0] = arr[0];
                dp[0][1] = arr[0]; // 첫 번째 수를 제거할 수는 없으므로 (적어도 1개 선택) 일단 값 넣어둠

                int max = arr[0]; // 정답변수
                
                // 점화식 수행
                for(int i=1; i<N; i++) {
                    //Case1: 제거안한 케이스 , (1) 이전까지의 합에 날 더하거나, 나부터 새로 시작하거나
                    dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);

                    //Case2: 수 하나를 제거함 (핵심)
                    //(1) 이번 i번 째를 제거하는 경우 -> 이전(i-1) 까지는 제거 안되어있어야함 (dp[i-1][0])
                    //(2) 이전에 이미 제거한 경우 -> 나는 더해져야함 (dp[i-1][1] + arr[i])
                    dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);

                    max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
                    // 제거하지 않아도 되기에 dp[i][0]과 dp[i][1] 을 또 비교한다. 만약에 무조건 제거해야한다고 하면
                    // max(max, dp[i][1]) 으로 사용하는게 옳은가?
                }

                System.out.println(max);


            }
        }