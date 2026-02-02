import java.util.*;
import java.io.*;

class Main {

    // 그리디 핵심 로직: 뺄셈의 뒤는 플..
    // 100-40+50+74-30+29-45+43+11 ... -222
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] minusStrArray = str.split("-");
        int sum = 0;
        for(int i=0; i<minusStrArray.length; i++){
            String[] minusStr = minusStrArray[i].split("[+]");
            for(int j=0; j<minusStr.length; j++){
                if(i==0){
                    sum += Integer.parseInt(minusStr[j]);
                } else {
                    sum -= Integer.parseInt(minusStr[j]);
                }
            }
        }
        System.out.println(sum);
    }
}