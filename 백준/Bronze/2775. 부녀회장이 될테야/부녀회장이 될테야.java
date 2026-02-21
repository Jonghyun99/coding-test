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
            int[][] apt = new int[15][15];
            for(int i=1; i<15; i++){
                apt[0][i] = i;
                apt[i][1] = 1;
            }

            for(int i=1; i<15; i++){
                for(int j=2; j<15; j++){
                    apt[i][j] = apt[i][j-1] + apt[i-1][j];
                }
            }

            int T = sc.nextInt();
            for(int i=0; i<T; i++){
                int floor = sc.nextInt();
                int number = sc.nextInt();
                System.out.println(apt[floor][number]);
            }

        }
    }