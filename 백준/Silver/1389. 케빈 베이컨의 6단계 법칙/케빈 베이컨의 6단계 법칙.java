import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<Integer>[] friendGraph;

    static int N,M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friendGraph = new ArrayList[N+1];
        result = new int[N+1];
        for(int i=0; i<=N; i++) {
            friendGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendGraph[a].add(b);
            friendGraph[b].add(a);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int resultPerson = - 1;

        for(int i=1; i<=N; i++) {
            int currentSum = BFS(i);
            
            if(currentSum < minKevinBacon) {
                minKevinBacon = currentSum;
                resultPerson = i;
            }
        }

        System.out.println(resultPerson);
    }

    static int BFS(int startFriend) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[N+1];
        q.add(startFriend);
        Arrays.fill(dist, -1);
        dist[startFriend] = 0;
        int sum = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next:friendGraph[now]) {
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    sum += dist[next];
                    q.add(next);
                }
            }
        }
        return sum;
    }
}
