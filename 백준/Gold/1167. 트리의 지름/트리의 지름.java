    import java.util.*;
    import java.io.*;

    class Main{

        static ArrayList<Node>[] nodes;
        static boolean[] visited;
        static int maxDistance = 0;
        static int maxNode = 0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                nodes[i] = new ArrayList<>();
            }
            for(int i=1; i<=V; i++){
                st = new StringTokenizer(br.readLine());
                
                int nodeNum = Integer.parseInt(st.nextToken());

                while(true) {
                    int nowVertex = Integer.parseInt(st.nextToken());
                    if(nowVertex == -1) break;
                    int nowLength = Integer.parseInt(st.nextToken());
                    nodes[nodeNum].add(new Node(nowVertex, nowLength));
                }
            }

            // 트리의 지름 구하는 로직 스타트 DFS를 이용하여 임의의 점에서 가장 먼 길이의 노드를 구하고
            // 그 노드에서 출발하여 가장 먼 노드의 길이 값을 구하라
            // + dfs, bfs 사용예 복습하기
            visited = new boolean[V+1];
            DFS(1,0);
            visited = new boolean[V+1];
            DFS(maxNode, 0);
            System.out.println(maxDistance);


        }

        static void DFS(int currentNode, int currentLength) {
            
            visited[currentNode] = true;

            if(maxDistance<currentLength) {
                maxDistance = currentLength;
                maxNode = currentNode;
            }

            for(Node next:nodes[currentNode]){
                int vertex = next.vertex;
                int length = next.length;
                if(!visited[vertex]){
                    DFS(vertex,currentLength + length);
                }

            }
        }





        static class Node {
            int vertex;
            int length;

            Node(int vertex, int length) {
                this.vertex = vertex;
                this.length = length;
            }
        }


    }