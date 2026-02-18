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

public class Main {

    static int N, M;
    static int[] parent;
    static ArrayList<Edge> adjGraph = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int weight;

        Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }


        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjGraph.add(new Edge(a, b, w));
        }

        // 가중치 순 오름차순 정렬, 이렇게 해도 전체 배열이 정렬되나?
        Collections.sort(adjGraph);

        //추가로, ArrayList<Edge>[] 의 배열을 weight순으로 전체 정렬 한다면?

        // 인접리스트를 배열로 만들어서 한 노드를 배열인덱스로 담고, 나머지 노드를 원소로 추가해서 쓰는 이유,
        // 그냥 배열 쓰지 말고 두 노드 다 원소로 쓰면 안되나? 

        int cnt = 0;
        long totalWeight=0;
        for(Edge edge:adjGraph) {
            int nodeA = edge.nodeA;
            int nodeB = edge.nodeB;
            if(find(nodeA) != find(nodeB)) {
                union(nodeA, nodeB);
                totalWeight += edge.weight;
            }
            if(cnt == N-1) break;
        }
        System.out.println(totalWeight);
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra>rb)
            parent[ra] = rb;
        else 
            parent[rb] = ra;
    }
}