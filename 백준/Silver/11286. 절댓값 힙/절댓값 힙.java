import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs == secondAbs) {
                return o1 >= o2 ? 1 : -1;
            } else {
                return firstAbs - secondAbs;
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.offer(num);
            }
                
        }
        System.out.println(sb.toString());

    }

}