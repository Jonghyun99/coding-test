import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    // 도시가 N개 있다. 도시 사이에는 길이 있을수도, 없을 수도 있다.
    // 여행 경로가 가능한지 알아보는 로직
    // 다른 도시를 경유할 수 있으며 방문한 도시를 또 방문해도 된다.
    // 여행 계획이 순서대로 주어졌을 시 전부 방문할 수 있는지 판별하라
    // 시간 2초, 입력 N <= 200, 여행계획 M <=1000
    // 1이면 연결된 도시, 0이면 연결되지않음
    // 마지막 줄에는 여행계획이 입력된다.
    // O(N^2) 가능
    // A B가 이어져있고, A C가 이어져있고, B C가 안이어진 경우 A - B - A - C로 가능하다.
    // 어떻게 판별할 것인가?
    // DFS 써야하는거 아니야?.. 일단해보자

    static ArrayList<Integer>[] cityGraph;
    static boolean[] visited; // 이전 도시에서 다음 도시 가는 경우의수는 안세기 위해 N*N할당
    static int[] plans;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        cityGraph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            cityGraph[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int isConnected = Integer.parseInt(st.nextToken());
                if(isConnected==1){
                    cityGraph[i].add(j);
                }
            }
        }
        plans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            plans[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+1];
        DFS(plans[0]);

        boolean possible = true;
        for(int city:plans)
        if(!visited[city]){
            possible = false;
            break;
        }

        if(possible) System.out.println("YES");
        else System.out.println("NO");
    }

    static void DFS(int city) {
        visited[city] = true;
        for(int nextCity: cityGraph[city]) {
            if(!visited[nextCity]){
                DFS(nextCity);
            }
        }

    }

}