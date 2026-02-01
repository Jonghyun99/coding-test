import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }

        int sum=0;
        while(pq.size()>1){
            int card1 = pq.poll();
            int card2 = pq.poll();
            sum += card1+card2;
            pq.add(card1+card2);
        }
        System.out.println(sum);
    }
}
