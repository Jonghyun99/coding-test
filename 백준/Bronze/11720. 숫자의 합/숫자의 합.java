import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        int answer = 0;
        for(char c:sNum.toCharArray()){
            answer += c-'0';
        }
        System.out.print(answer);
    }
}
    
    