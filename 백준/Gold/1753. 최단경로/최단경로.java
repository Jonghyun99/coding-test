import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int vertex, value;
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        // return 1이면 어떻게 정렬되지? 왼쪽놈이 뒤로가나? return o1 -o2 하면 오름차순이고 o1이 앞으로 가잖아
        // 오름차순은 작은거부터 앞에가는거니까 음수 return하여야 오름차순인거네? 여기는 this.value가 인자보다 클 경우
        // 인자를 앞에 세우라고 하는건가? 인자로 들어온 값이 더 작을 경우 앞에 세워라 하는 로직같네, 복잡하게 생각할 거 없이 외우면 좋을 식이 있을까?
        if(this.value > o.value) return 1;
        else return -1; // 이거는 인자가 더 클 경우, 함수를 호출받는 변수(뭐라고 모르겠네)를 더 앞에 세우라는 거 같다.
    }
    

}

public class Main {

    static int V,E,K;
    static int distance[];
    static boolean visited[];
    static ArrayList<Edge> list[];
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 노드의 개수
        E = Integer.parseInt(st.nextToken()); // 에지의 개수
        K = Integer.parseInt(br.readLine()); // 출발노드 K
        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1]; // list는 무슨 역할이지?
        for(int i=1; i<= V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<=V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // 가중치 있는 인접 리스트 초기화 하기
        for(int i=0; i< E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if(visited[c_v]) continue;
            visited[c_v] = true;

            for(int i=0; i<list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(distance[next] > distance[c_v] + value) {
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}