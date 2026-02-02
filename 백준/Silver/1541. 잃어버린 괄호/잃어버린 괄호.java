import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-+",true);

        int sum = Integer.parseInt(st.nextToken());
        boolean isMinusSeen = false;

        while(st.hasMoreTokens()) {
            String token = st.nextToken();

            if(token.equals("-")){
                isMinusSeen = true;
            } else if(token.equals("+")){

            } else {
                if(isMinusSeen) {
                    sum-=Integer.parseInt(token);
                } else {
                    sum+=Integer.parseInt(token);
                }
            }
        }
        System.out.println(sum);
    }
}