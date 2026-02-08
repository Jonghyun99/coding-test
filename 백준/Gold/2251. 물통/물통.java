    import java.util.ArrayDeque;
    import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
    import java.util.Scanner;

    import javax.crypto.AEADBadTagException;

    class State {
        int a, b;
        public State(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public class Main {

        // 부피가 1<= A, B, C <= 200 물통 3개
        // A, B는 비어있고  C는 꽉차있다.
        // A물통이 비어있을 때 C에 담겨 있을 수 있는 물의 양을 모두 구하는 프로그램을 작성하시오
        // 시간제한 1초
        // ex) 입력 8,9,10 -> 출력 1,2,8,9,10
        // C에서 얻을 수 있는 경우의 수 구하는 문제 -> DFS로 해결 시간복잡도는 O노드(노드+간선) 맞나? 모든 물통 시작별로 다 해봐야하니..
        // 어떤 자료구조를 써야하나
        // 1. 일단 C에 담겼던 물의 양을 기록하는 배열은 하나 필요할 것 같고
        // 2. A에서 C에 담고,, C에서 B에 담고,, 남으면 다시 A에서 C에 담고..
        // 인접 리스트 맞나..?
        // 물을 옮긴다 생각하지 말고 연산으로 생각해보면..
        // 모르겠다 정답보자 (정상인가요?)

        static int[] limit = new int[3];
        static boolean[][] visited = new boolean[201][201];
        static ArrayList<Integer> answer = new ArrayList<>();
        
        // 이 두 배열은 어떻게 나오는건데? 공식처럼 외워야하는건가?
        static int[] sender = {0, 0, 1, 1, 2, 2};
        static int[] receiver = {1, 2, 0, 2, 0, 1};
        

        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            limit[0] = sc.nextInt();
            limit[1] = sc.nextInt();
            limit[2] = sc.nextInt();

            BFS();
            Collections.sort(answer);
            for(int num : answer) {
                System.out.print(num + " ");
            }
        }

        static void BFS() {
            Queue<State> q = new ArrayDeque<>();
            // 초기 상태 A, B = 0, C 가득참
            q.add(new State(0, 0));
            visited[0][0] = true;
            while(!q.isEmpty()) {
                State now = q.poll();
                int nowA = now.a;
                int nowB = now.b;
                int nowC = limit[2] - nowA - nowB; // 핵심 C는 계산으로 구함
                
                // 문제 조건, A가 비어있을 때  C의 물의 양 저장
                if(nowA == 0){
                    answer.add(nowC);
                }

                for(int i = 0; i<6; i++){
                    int[] next = {nowA, nowB, nowC};
                    int from = sender[i];
                    int to = receiver[i];

                    // 물을 옮기는 로직, 핵심
                    // 옮길 수 있는 양 = Min(보내는 쪽 물의 양, 받는 쪽 남는 공간)
                    // 예 A(5L) -> B(공간3L남음): 3L만 이동가능
                    // 예 A(2L) -> B(공간3L남음): 전부 이동가능
                    int amount = Math.min(next[from], limit[to] - next[to]);

                    next[from] -= amount;
                    next[to] += amount;

                    if(!visited[next[0]][next[1]]) {
                        visited[next[0]][next[1]] = true;
                        q.add(new State(next[0], next[1]));
                    }
                }
            }
        }
    }