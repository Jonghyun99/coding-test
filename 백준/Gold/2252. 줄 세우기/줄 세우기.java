import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCount = Integer.parseInt(st.nextToken());
        int compareCount = Integer.parseInt(st.nextToken());

        int[] indegree = new int[studentCount+1];
        ArrayList<Integer>[] adjGrpah = new ArrayList[studentCount+1];
        for(int i=1; i<=studentCount; i++) {
            adjGrpah[i] = new ArrayList<>();
        }

        for(int i=0; i<compareCount; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A가 B보다 앞에 서야함
            // adjGrpah[B].add(A); 논리적으로는 이 코드가 맞지 않나..? B에 몇명 붙어있는지 세야하니까 이거같은데 맞아?
            adjGrpah[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=studentCount; i++) {
            if(indegree[i] == 0) {
                q.offer(i);                
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            for(int next:adjGrpah[current]){
                indegree[next]--;
                if(indegree[next]==0) {
                    q.add(next);
                }
            }
        }

        System.out.print(sb);

    }
}