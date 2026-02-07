import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 시간제한 5초
    // N <= 10,000, M <= 100,000
    // A <- B 형식의 인접 그래프
    // 가장 많이 연결된 노드를 오름차 순 출력하라 (BFS 사용하여 각 노드 for문 순회)
    // 시간복잡도는 O(nlogn)> ? >O(N^2)) 맞나?
    static boolean[] visited;
    static ArrayList<Integer>[] computers;
    static int[] connectedComputerCounterArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int computerCount = Integer.parseInt(st.nextToken());
        int connectedCount = Integer.parseInt(st.nextToken());

        visited = new boolean[computerCount+1];
        computers = new ArrayList[computerCount+1];
        connectedComputerCounterArray = new int[computerCount+1];

        for(int i=1; i<=computerCount; i++){
            computers[i] = new ArrayList<>();
        }

        for(int i=0; i<connectedCount; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // s가 e를 신뢰하며 이 때 e를 해킹하면 s도 해킹할 수 있다.
            // e -> s -> ..
            // 가장 많이 해킹할 수 있는 번호는?
            computers[e].add(s);
        }

        for(int i=1; i<=computerCount; i++){
            Arrays.fill(visited,false);
            BFS(i);
        }
        
        int max = 0;
        for(int i=1; i<=computerCount; i++){
            max = Math.max(max, connectedComputerCounterArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=computerCount; i++){
            if(connectedComputerCounterArray[i] == max) sb.append(i+" ");
        }

        System.out.println(sb);
    }

    static void BFS(int computerNum) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(computerNum);
        visited[computerNum]= true;
        // connectedComputerCounterArray[computerNum] = 0;
        while(!q.isEmpty()) {
            int nowComputer = q.poll();

            // 이구간에 코드가 있다면 어떤코드들이 들어가더라?

            for(int nextComputer:computers[nowComputer]) {
                if(!visited[nextComputer]){
                    visited[nextComputer] = true;
                    q.add(nextComputer);
                    // 코드랑 별개의 다른이야기인데 connectedComputerCounterArray[nextComputer] = connectedComputerCounterArray[nowComputer]++; 
                    // connectedComputerCounterArray[nextComputer] = connectedComputerCounterArray[nowComputer] + 1; 이렇게 2개 똑같이 동작하던가?
                    connectedComputerCounterArray[computerNum]++;
                }
            }
        }

    }
}