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

    static boolean[] visited;
    static ArrayList<Integer>[] connectGraph;
    static int[] deepthArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computerCnt = Integer.parseInt(st.nextToken());
        int connectCnt = Integer.parseInt(st.nextToken());

        visited = new boolean[computerCnt+1];
        connectGraph = new ArrayList[computerCnt+1];
        deepthArray = new int[computerCnt+1];
        for(int i=1; i<=computerCnt; i++){
            connectGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<connectCnt; i++){
            st = new StringTokenizer(br.readLine());
            int comA = Integer.parseInt(st.nextToken());
            int comB = Integer.parseInt(st.nextToken());

            // 여기 순서 바뀌면 안되지??
            connectGraph[comB].add(comA);
        }
        for(int i=1; i<=computerCnt; i++){
            visited = new boolean[computerCnt+1];
            BFS(i);
        }

        int max = 0;
        for(int i=1; i<=computerCnt; i++){
            max = Math.max(max, deepthArray[i]);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=computerCnt; i++){
            if(max==deepthArray[i]) sb.append(i+" ");
        }
        System.out.println(sb);
    }

    static void BFS(int startComputer) {
        // 좋은 변수명이 생각안나네
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startComputer);
        visited[startComputer] = true;
        while(!queue.isEmpty()){
            int nowComputer = queue.poll();
            for(int nextComputer : connectGraph[nowComputer]) {
                if(!visited[nextComputer]){
                    visited[nextComputer] = true;
                    queue.add(nextComputer);
                    deepthArray[startComputer]++;
                }
            }
        }
    }

}