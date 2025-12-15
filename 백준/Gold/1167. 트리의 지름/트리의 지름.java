    import java.util.*;
    import java.io.*;

class Main{

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while(true){
                int linkedNode = Integer.parseInt(st.nextToken());
                if(linkedNode==-1) break;

                int weight = Integer.parseInt(st.nextToken());
                list[node].add(new Edge(linkedNode, weight));
            }
        }

        // 임의 노드에서 가장 먼 노드 찾기
        visited = new boolean[V+1];
        dfs(1, 0);        

        visited = new boolean[V+1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    public static void dfs(int node, int dist){
        if(dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        visited[node] = true;

        for(Edge edge:list[node]){
            if(!visited[edge.to]){
                dfs(edge.to, dist+edge.weight);
            }
        }
    }
    
}
