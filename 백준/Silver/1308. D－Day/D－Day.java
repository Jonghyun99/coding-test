import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class Main {

    // 2008 12 27
    // 2009 1 22
    // D-26

    // 오늘부터 D-Day까지 x일이 남았다면, "D-"를 출력하고 그 뒤에 공백 없이 x를 출력한다.
    // 만약 캠프가 천년 이상 지속된다면 (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면)
    // 대신 "gg"를 출력한다. 오늘이 2월 29일인 경우는 주어지지 않는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LocalDate startDate = LocalDate.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        LocalDate endDate = LocalDate.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        long year = ChronoUnit.YEARS.between(startDate, endDate);
        long day = ChronoUnit.DAYS.between(startDate, endDate);

        if (year >= 1000) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + day);
        }

    }
}