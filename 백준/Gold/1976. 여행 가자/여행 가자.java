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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int isCon = Integer.parseInt(st.nextToken());
                if(isCon == 1) {
                    if(j>i)
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        boolean possible = true;
        for(int i=1; i<M; i++){
            int nextCity = Integer.parseInt(st.nextToken());
            if(find(startCity) != find(nextCity)){
                possible = false;
                break;
            }
        }
        
        if(possible) System.out.println("YES");
        else System.out.println("NO");
    }     

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if(ra != rb) {
            // 낮은 쪽이 부모 되고있는 로직 잘짠거 맞지? 배열인덱스가 자식, 값이 부모
            if(ra>rb) parent[ra] = rb; 
            else parent[rb] = ra;
        }
    }
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}