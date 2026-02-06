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
    static int[] distanceArray;
    static ArrayList<Integer>[] roadArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());
        int targetDistance = Integer.parseInt(st.nextToken());
        int departCity = Integer.parseInt(st.nextToken());

        roadArray = new ArrayList[cityCount+1];
        for(int i=1; i<=cityCount; i++){
            roadArray[i] = new ArrayList<>();
        }

        distanceArray = new int[cityCount+1];
        Arrays.fill(distanceArray,-1);
        distanceArray[departCity] = 0;
        boolean found = false;
        for(int i=0; i<roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            roadArray[startCity].add(endCity);
        }

        BFS(departCity);

        int cnt = 0;
        for(int i=1; i<=cityCount; i++){
            if(distanceArray[i]==targetDistance){
                System.out.println(i);
                cnt++;
            }
        }
        if(cnt==0) {
            System.out.println(-1);
        }

        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // for(int i=1; i<=cityCount; i++) {
        //     if(distanceArray[i] == targetDistance){
        //         bw.write(i);
        //     }
        // }
        // bw.flush();
        // bw.close();
    }

    static void BFS(int departCity) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(departCity);
        while(!queue.isEmpty()) {
            int nowCity = queue.poll();
            for(int nextCity:roadArray[nowCity]) {
                if(distanceArray[nextCity] == -1) {
                    distanceArray[nextCity] = distanceArray[nowCity] + 1;
                    queue.add(nextCity);
                }
            }

        }
    }
}
