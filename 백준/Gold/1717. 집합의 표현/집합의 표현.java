import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(q==0) {
                union(a,b);
            } else {
                if(find(a)==find(b))
                    System.out.println("YES");
                else 
                    System.out.println("NO");
            }
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootA] = rootB;
            // 1 2 3 4 5 에서 union (1 3) 할 시 1이 3의 부모가 됨
            // parent[3] = 1이 나와야함
            // 고로 union(a,b)에서 parent[b] 할시 a가 나와야 하므로
            // parent[b] = a 순서가 맞지?
        }
    }

}