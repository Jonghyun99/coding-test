    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0; i<N; i++){
                pq.add(sc.nextInt());
            }
            int lefthand = 0;
            int righthand = 0;
            int cnt = 0;
            while(pq.size()!=1) {
                lefthand = pq.remove();
                righthand = pq.poll();
                cnt += lefthand + righthand;
                pq.add(lefthand+righthand);
            }
            System.out.println(cnt);
        }


    }