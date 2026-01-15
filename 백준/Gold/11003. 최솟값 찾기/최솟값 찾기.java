    import java.util.*;
    import java.io.*;

    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Deque<Node> myDeque = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int now = Integer.parseInt(st.nextToken());
                
                while(!myDeque.isEmpty() && myDeque.getLast().value > now) {
                    myDeque.removeLast();
                }
                myDeque.addLast(new Node(i, now));

                if(myDeque.getFirst().index <= i-L) {
                    myDeque.removeFirst();
                }
                bw.write(myDeque.getFirst().value + " ");
            }
            bw.flush();
        }

       static class Node {
            int value;
            int index;

            Node(int index, int value){
                this.index = index;
                this.value = value;
            }
        }

    }

