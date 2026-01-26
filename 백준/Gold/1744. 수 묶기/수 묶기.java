import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            if(data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if(data==0){
                zero++;
            } else {
                minusPq.add(data);
            }
        }
        int sum = 0;
        while(plusPq.size()>1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }

        if(!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        while(minusPq.size()>1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }
        if(!minusPq.isEmpty()) {
            if(zero == 0){
                sum += minusPq.remove();
            }
        }

        sum += one;
        System.out.println(sum);
    }

}