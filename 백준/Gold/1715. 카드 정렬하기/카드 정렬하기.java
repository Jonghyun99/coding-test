    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=0; i<N; i++){
                queue.offer(sc.nextInt());
            }
            int data1 = 0;
            int data2 = 0;
            int cnt = 0;

            while(queue.size() >1) {
                data1 = queue.remove();
                data2 = queue.remove();
                cnt += data1+data2;
                queue.offer(data1+data2);
            }
            System.out.println(cnt);
            
        }


    }