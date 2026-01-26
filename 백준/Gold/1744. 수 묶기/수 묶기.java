import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n>1) {
                plusQueue.add(n);
            } else if(n==1) {
                one++;
            } else if (n==0) {
                zero++;
            } else {
                minusQueue.add(n);
            }
        }

        int sum = 0;
        while(plusQueue.size()>1) {
            int num1 = plusQueue.poll();
            int num2 = plusQueue.poll();

            sum+= num1*num2;
        }
        if(!plusQueue.isEmpty()) {
            sum += plusQueue.poll();
        }

        while(minusQueue.size()>1) {
            int num1 = minusQueue.poll();
            int num2 = minusQueue.poll();
            sum += num1*num2;
        }

        if(!minusQueue.isEmpty()) {
            if(zero==0) sum += minusQueue.poll();
        }

        sum += one;

        System.out.println(sum);
    }

}