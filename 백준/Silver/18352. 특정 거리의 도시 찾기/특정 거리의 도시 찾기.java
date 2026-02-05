import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] roadInfo;
    static int targetDistance;
    static int cnt = 0;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());
        targetDistance = Integer.parseInt(st.nextToken());
        int initCity = Integer.parseInt(st.nextToken());
        
        distance = new int[cityCount+1];
        roadInfo = new ArrayList[cityCount+1];
        for(int i=1; i<=cityCount; i++) {
            roadInfo[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for(int i=0; i<roadCount; i++){
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            roadInfo[startCity].add(endCity);
        }
        
        BFS(initCity,0);
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i=1; i<= cityCount; i++){
            if(distance[i] == targetDistance){
                sb.append(i).append("\n");
                found = true;
            }
        }

        if(found) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }

    // startCity로부터 깊이가 K인 도시들을 탐색하므로.. BFS가 아닌 DFS 사용?
    static void BFS(int currentCity, int deepth) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(currentCity);
        distance[currentCity] = 0;
        while(!queue.isEmpty()) {
            int nowCity = queue.poll();
            for(int nextCity:roadInfo[nowCity]) {
                if(distance[nextCity] == -1){
                    distance[nextCity] = distance[nowCity] + 1;
                    queue.add(nextCity);
                }
            }
        }
    }
}
