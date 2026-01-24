    import java.util.*;
    import java.io.*;

    class Main{

        static int[] dist;
        static int maxNode;
        static int maxDist;
        static boolean[] visited;
        static ArrayList<Edge>[] edges;


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            
            edges = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                edges[i] = new ArrayList<>();
            }


            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                while(true){
                    int e = Integer.parseInt(st.nextToken());
                    if(e==-1) break;
                    int v = Integer.parseInt(st.nextToken());

                    edges[s].add(new Edge(e, v));
                }
            }
            visited = new boolean[N+1];
            dist = new int[N+1];
            BFS(1);
            visited = new boolean[N+1];
            dist = new int[N+1];
            BFS(maxNode);
            System.out.println(maxDist);
        }

        static void BFS(int index) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(index);
            visited[index] = true;

            while(!queue.isEmpty()) {
                int nowNode = queue.poll();

                if(dist[nowNode] > maxDist) {
                    maxDist =  dist[nowNode];
                    maxNode = nowNode;
                }

                for(Edge edge:edges[nowNode]) {
                    int e = edge.e;
                    int v = edge.value;
                    if(!visited[e]){
                        queue.add(e);
                        visited[e] = true;
                        dist[e] = dist[nowNode] + v;
                    }
                }
            }
        }


    }
    class Edge {
        int e;
        int value;

        Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }