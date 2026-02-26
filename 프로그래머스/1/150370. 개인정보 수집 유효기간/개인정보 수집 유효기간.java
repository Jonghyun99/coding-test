import java.util.*;
import java.io.*;

class Solution {
    // terms
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String[] termArray = new String[terms.length];
        int[] duration = new int[terms.length];
        
        Map<String,Integer> termMap = new HashMap<String,Integer>();
        for(int i=0; i<terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        String[] todaySplit = today.split("\\.");
        int todayYear = Integer.parseInt(todaySplit[0]);
        int todayMonth = Integer.parseInt(todaySplit[1]);
        int todayDay = Integer.parseInt(todaySplit[2]);
        
        int totalToDay = (todayYear * 12 * 28) + (todayMonth*28) + todayDay;
        // int[] answer = new int[terms.length+1];
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<privacies.length; i++) {
            String[] privaciesStr = privacies[i].split(" ");
            String[] privaciesSplit = privaciesStr[0].split("\\.");
            String termsType = privaciesStr[1];
            
            int privaciesYear = Integer.parseInt(privaciesSplit[0]);
            int privaciesMonth = Integer.parseInt(privaciesSplit[1]);
            int privaciesDay = Integer.parseInt(privaciesSplit[2]);
            int privaciesTotalDay = (12*28*privaciesYear) + (28*privaciesMonth) + privaciesDay;
            
            privaciesTotalDay += termMap.get(termsType);
            
            System.out.println("privaciesTotalDay: " + privaciesTotalDay + ", totalToday: " + totalToDay);            
            if(privaciesTotalDay <= totalToDay) {
                answer.add(i+1);
            }
        }
        // for(int n:answer){
        //     System.out.println("answer: " +n);
        // }       
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}