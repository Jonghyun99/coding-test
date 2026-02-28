import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();
        // 배열은 length, 문자열은 length(), 리스트는 .sized() 맞나? 다른거 더없었지?
        for(int i=0; i<terms.length; i++){
            String[] termStr = terms[i].split(" ");
            map.put(termStr[0], Integer.parseInt(termStr[1]));
        }
        
        int totalToday = getDay(today);
        
        for(int i=0; i<privacies.length; i++) {
            String[] privStr = privacies[i].split(" ");
            int privDay = getDay(privStr[0]);

            String condition = privStr[1];
            int monthForAdd = map.get(condition) * 28;
            
            privDay += monthForAdd;
            
            // 이거 왜 <= 이지? < 아닌가? 파기 일이 5.10일인데 오늘 날짜가 5.11일이면 아직 파기 안하는거잖아
            // 이걸 식으로 표현하면 privDay<totalDay 일 경우 파기안함
            // 오늘날짜가 5.10일 때도 파기 안하는거잖아 privDay==totalDay
            // 오늘날짜가 5.9이면 파기 해야지 priv>totalDay이니까
            // 그니까 priv>totalDay 일때만 answer.add(i+1) 을 해야하는거 아닌가? 왜 반대지
            if(privDay<=totalToday) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int getDay(String date) {
        String[] str = date.split("\\.");
        int year = Integer.parseInt(str[0]) * 12 * 28;
        int month = Integer.parseInt(str[1]) * 28;
        int day = Integer.parseInt(str[2]);
        
        return year+month+day;
    }
}