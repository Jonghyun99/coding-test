import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        int cnt = 0;
        while(queue.size() > 1){
            if(cnt%2==0){
                queue.remove();
            } else {
                queue.add(queue.remove());
            }
            cnt++;
        }
        System.out.println(queue.peek());
       

    }

}
