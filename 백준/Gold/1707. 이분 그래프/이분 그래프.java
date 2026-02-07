import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjGraph;
    static int[] colors;
    static boolean isBiparitie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            adjGraph = new ArrayList[nodeCount+1];
            colors = new int[nodeCount+1];
            for(int j=1; j<=nodeCount; j++){
                adjGraph[j] = new ArrayList<>();
            }

            // System.out.println("nodeCount: " + nodeCount + " edgeCount: " + edgeCount);
            for(int j=0; j<edgeCount; j++){
                st = new StringTokenizer(br.readLine());
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                adjGraph[startNode].add(endNode);
                // 문제엔 언급을 못찾았는데, 인접한 두 노드면 서로 연결된 그래프 맞겠지???
                adjGraph[endNode].add(startNode);
            }

            // 덩어리 찾는 문제이므로 DFS, BFS 둘다 상관 없이 사용 가능할 듯 하다. 
            // 만약 끊어진 부분을 찾으라거나, 순환구조인지 찾으라는건 DFS 써야하나? 왜 BFS로는 안될까? 
            // 한번 탐색을 마친 후에, visited에 false로 남아있는 요소가 있으면 이분 그래프로 취급하자.
            
            isBiparitie = true;
            for(int j=1; j<=nodeCount; j++){
                if(!isBiparitie) break;

                if(colors[j] ==0)
                BFS(j);
            }

            if(isBiparitie) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static void BFS(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        colors[node] = 1;
        while(!q.isEmpty()) {
            int nowNode = q.poll();
            for(int nextNode:adjGraph[nowNode]){
                if(colors[nextNode] == 0){
                    q.add(nextNode);
                    colors[nextNode] = colors[nowNode] * -1;
                } else if(colors[nextNode] == colors[nowNode]) {
                    isBiparitie = false;
                    return;
                }
            }
        }
    }

}