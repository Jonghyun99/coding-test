import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] lectures = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 강의실이 1개일 때와는 다르게 시작시간 오름차순으로 정렬한다. 왜? 그래야 겹치는 강의들을 판별할 수 있으니까
        Arrays.sort(lectures, (lectrue1, lectrue2) -> {
            if(lectrue1[0] == lectrue2[0]) 
                return Integer.compare(lectrue1[1], lectrue2[1]);
            return Integer.compare(lectrue1[0], lectrue2[0]);
        });

        // 우선순위 큐 선언, (종료시간을 저장, 자동으로 오름차순 정렬됨)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]); //첫번째 수업 큐에 넣기
        
        //2번째 큐부터 순회
        for(int i=1; i < N; i++) {
            // 현재 가장 빨리 끝나는 강의실의 종료시간 <= 다음 수업의 시작 시간
            if(pq.peek() <= lectures[i][0]) {
                pq.poll();  // 강의실을 이어 쓸 수 있을 경우에는 하나 제거
            }
            pq.add(lectures[i][1]);
        }
        System.out.println(pq.size());
    }
}
