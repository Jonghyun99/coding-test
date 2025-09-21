import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String scores = sc.nextLine();
        int max = Integer.MIN_VALUE;
        for(String score:scores.split(" ")) {
            max = Math.max(max,Integer.parseInt(score));
        }
        double sum = 0;
        for(String score:scores.split(" ")) {
            sum += Double.parseDouble(score)/max * 100;
        }
        System.out.println(sum/N);
    }
}