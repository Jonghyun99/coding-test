        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.StringTokenizer;

        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                // D[i][j] = i,j 를 우하단으로 하였을 때 그릴 수 있는 가장 큰 정사각형 한 변의 길이
                int[][] DP = new int[N+1][M+1];

                long maxSide = 0;

                for(int i=1; i<=N; i++) {
                    String line = br.readLine();
                    for(int j=1; j<=M; j++){
                        int temp = line.charAt(j-1)-'0';
                        // 1인 경우에만 정사각형 만들 수 있음
                        if(temp==1){
                            // 내 위(i-1, j) 왼쪽 (i,j-1), 대각선 위(i-1, j-1) 중
                            // 가장 작은 값 + 1이 내가 만들 수 있는 정사각형 의 크기 (이해가 안되네, 한 변이 붙어있다고 해서 어떻게 정사각형이 됨?)
                            // 이걸로 정사각형 (4변이 다 1이 되는지 어떻게 검증하는거지)
                            DP[i][j] = Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1])) +1;
                            maxSide = Math.max(maxSide, DP[i][j]);
                        }
                    }
                }
                System.out.println(maxSide*maxSide);                 

            }
        }