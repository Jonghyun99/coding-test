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

class Status {
    int a;
    int b;

    Status(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    static int limit[] = new int[3];
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[][] visited = new boolean[201][201];    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        limit[0] = sc.nextInt();
        limit[1] = sc.nextInt();
        limit[2] = sc.nextInt();

        BFS(0,0);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int num: answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    static void BFS(int A, int B) {
        Queue<Status> q = new ArrayDeque<>();
        q.add(new Status(A, B));
        visited[A][B] = true;

        while(!q.isEmpty()) {
            Status now = q.poll();
            int a = now.a;
            int b = now.b;
            int c = limit[2] - a - b;

            if(a==0) answer.add(c);

            for(int i=0; i<6; i++){
                int[] next = {a,b,c};
                int to = sender[i];
                int from = receiver[i];

                int amount = Math.min(next[from] , limit[to] - next[to]);
                
                next[to] += amount;
                next[from] -= amount;

                if(visited[next[0]][next[1]]) continue;

                visited[next[0]][next[1]] = true;
                q.add(new Status(next[0], next[1]));
            }
        }
        
    }
}