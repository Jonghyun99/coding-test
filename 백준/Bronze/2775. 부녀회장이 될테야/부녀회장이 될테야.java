    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.StringTokenizer;


    public class Main {
        // A층 B호에 살려면 A-1층 1호부터 A-1층 B호의 사람들 합 만큼 데려와야 한다.
        // 이 때 A층 B호에 몇명이 살고 있는가?
        // 0층의 i호에는 i명이 산다.
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[][] d = new int[15][15];
            for(int i=1;i<15; i++){
                d[0][i] = i;
                d[i][1] = 1;
            }

            // 왜 여기선 i는 1, j는 2부터지? 아까랑 다르게? 헷갈리네? 기준이뭐지?
            for(int i=1; i<15; i++) {
                for(int j=2; j<15; j++) {
                    d[i][j] = d[i][j-1] + d[i-1][j];
                }
            }
            int T = sc.nextInt();
            for(int t=0; t<T; t++) {
                int floor = sc.nextInt();
                int num = sc.nextInt();
                System.out.println(d[floor][num]);                
            }
        }
    }