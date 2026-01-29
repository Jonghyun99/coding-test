import java.util.*;
import java.io.*;

class Main {

    // 입력: 에지의 번호와 에지의 가중치
    static ArrayList<Edge>[] edgeList;
    static int[] distance;
    static int maxNode, maxDistance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList[N+1];
        distance = new int[N+1];

        for(int i=1; i<=N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int targetNode = Integer.parseInt(st.nextToken());
                if(targetNode==-1) break;
                int targetDistance = Integer.parseInt(st.nextToken());
                edgeList[node].add(new Edge(targetNode, targetDistance));
            }
        }
        maxNode = 0;
        maxDistance = 0;
        Arrays.fill(distance,-1);
        BFS(1);
        Arrays.fill(distance,-1);
        BFS(maxNode);
        System.out.println(maxDistance);

    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        distance[node] = 0;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();

            if(maxDistance < distance[nowNode]) {
                maxDistance = distance[nowNode];
                maxNode = nowNode;
                // break;
            }

            for(Edge nextEdge:edgeList[nowNode]) {
                int nextTargetNode = nextEdge.targetNode;
                int nextDistance = nextEdge.distance;
                if(distance[nextTargetNode] == -1) {
                    distance[nextTargetNode] = distance[nowNode] + nextDistance;
                    queue.add(nextTargetNode);
                }
            }
        }
    }

}

class Edge {
    int targetNode;
    int distance;

    Edge (int targetNode, int distance) {
        this.targetNode = targetNode;
        this.distance = distance;
    }
}