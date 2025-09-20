import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sN = sc.next();
        int sum = 0;
        for(char c:sN.toCharArray()){
            sum += c-'0';
        }
        System.out.print(sum);
    }
}