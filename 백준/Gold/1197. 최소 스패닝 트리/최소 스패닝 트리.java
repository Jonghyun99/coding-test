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

    static int[] parent;
    static ArrayList<Edge> adj = new ArrayList<>();

    static class Edge implements Comparable<Edge> {

        int a;
        int b;
        int w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return Integer.compare(this.w, o.w);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1; i<=V; i++) {
            parent[i] = i;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            adj.add(new Edge(A, B, W));
        }
        Collections.sort(adj);

        long cnt = 0;
        long sum = 0;
        for(int i=0; i<E; i++){
            Edge now = adj.get(i);
            int A = now.a;
            int B = now.b;
            int W = now.w;
            if(union(A,B)) {
                cnt++;
                sum += W;
            }

            if(cnt==V-1) {
                break;
            }
        }
        System.out.println(sum);
        
    }   

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra==rb) return false;

        // ra랑 rb로 parent에 대입하는거 맞지?
        if(ra>rb) parent[ra] = rb;
        else parent[rb] = ra;

        return true;
    }   

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
     
}