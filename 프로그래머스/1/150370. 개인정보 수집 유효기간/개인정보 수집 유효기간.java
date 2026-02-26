import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> tm = new HashMap<>();
        for(String str:terms){
            StringTokenizer st = new StringTokenizer(str);
            tm.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        int totalToday = dateTodayInt(today);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] prStr = privacies[i].split(" ");
            String prDate = prStr[0];
            String prTerm = prStr[1];
            
            int totalPrDay = dateTodayInt(prDate);
            totalPrDay+=tm.get(prTerm)*28;
            
            // 파기해야할 번호를 담아야한다 -> totalToday가 높아야한다 
            // 유효기간이 25.01.05일 때, 오늘 날짜가 01.05이면 파기 x
            if(totalToday>=totalPrDay) {
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    static int dateTodayInt(String date){
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0])*28*12;
        int month = Integer.parseInt(arr[1])*28;
        int day = Integer.parseInt(arr[2]);
        return year + month + day;
    }
}