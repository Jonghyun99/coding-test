import java.util.*;
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int dataCount = sc.nextInt();
        int queryCount = sc.nextInt();
        int[] data = new int[dataCount];
        int[] s = new int[dataCount+1];
        for(int i=0; i<data.length; i++){
            data[i]=sc.nextInt();
        }
        for (int i=1; i<=data.length; i++) {
            s[i] = s[i-1] + data[i-1];
        }
        for(int a=0; a<queryCount; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int result = s[j] - s[i-1];
            System.out.println(result);
        }
    }
}