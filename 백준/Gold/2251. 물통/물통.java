import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

import javax.crypto.AEADBadTagException;

public class Main {

    static boolean[][] visited = new boolean[201][201];
    static int[] limit = new int[3];
    static int[] sender = { 0, 0, 1, 1, 2, 2 };
    static int[] receiver = { 1, 2, 0, 2, 0, 1 };
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // limit배열은 200칸까지 담아얗ㄴ다는 별도 표기가 없어도 되나?
        limit[0] = sc.nextInt();
        limit[1] = sc.nextInt();
        limit[2] = sc.nextInt();

        BFS();

        Collections.sort(answer);
        for(int num:answer){
            System.out.print(num + " ");
        }

    }

    static void BFS() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0 ,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowA = now[0];
            int nowB = now[1];
            int nowC = limit[2] - nowA- nowB;

            if(nowA==0) answer.add(nowC);

            for(int i=0; i<6; i++) {
                int[] next = {nowA, nowB, nowC};
                int from = sender[i];
                int to = receiver[i];

                int amount = Math.min(next[from], limit[to] - next[to]);
                
                next[to] += amount;
                next[from] -= amount;

                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new int[]{next[0], next[1]});
                }
            }  
        }
    }

}