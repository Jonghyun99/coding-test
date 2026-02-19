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

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p==-1) {
                root = i;
            } else {
                tree[i].add(p);
                tree[p].add(i);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode==root) {
            System.out.println(0);
        } else {
            BFS(root);
            System.out.println(answer);
        }
    }
    
    static void BFS(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        visited[root] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            int cNode = 0;
            for(int next:tree[now]) {
                if(!visited[next] && next!=deleteNode) {
                    q.add(next);
                    visited[next] = true;
                    cNode++;
                }
            }
            if(cNode==0) answer++;
        }
    }

}