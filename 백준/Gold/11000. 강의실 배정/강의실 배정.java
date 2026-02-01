import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures,(o1, o2) -> {
            // 시작시간 정렬하나 끝나는 시간은 정말 중요하지 않은지 확인하기
            // 시작 시간이 같은 경우, 끝나는 시간이 더 짧은 것을 넣어야 하기 때문에 상관없지않음.. 
            // ex 1~3 , 1~5, 3~5 가 있을경우 정렬하지 않으면 2개, 정렬하면 1개를 넣을 수 있음
            if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        endTimeQueue.add(lectures[0][1]);
        
        
        for(int i=1; i<N; i++) {
            if(endTimeQueue.peek() <= lectures[i][0]){
                endTimeQueue.poll();
            }

            endTimeQueue.add(lectures[i][1]);
        }

        System.out.println(endTimeQueue.size());
        
    }
}
