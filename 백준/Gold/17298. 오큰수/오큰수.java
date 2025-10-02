import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answerArray = new int[N];
        int[] A = new int[N];
        
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        // stack.push(0);
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answerArray[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answerArray[stack.pop()] = -1;
        }
        StringBuffer sb = new StringBuffer();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(answerArray[i] +" ");
            // sb.append(answerArray[i]);
        }
        bw.flush();
        bw.close();
        

    }

}
