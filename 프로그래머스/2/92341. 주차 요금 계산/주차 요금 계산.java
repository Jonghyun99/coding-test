import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkStatusMap = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();
        
        // 시간계산
        for(String record:records) {
            String[] parkInfo = record.split(" ");
            int time = getTime(parkInfo[0]);
            String carNumber = parkInfo[1];
            String action = parkInfo[2];
            
            if(action.equals("IN")) {
                parkStatusMap.put(carNumber, time);
            } else {
                int inTime = parkStatusMap.remove(carNumber);
                int spendingTime = time - inTime;
                timeMap.put(carNumber,timeMap.getOrDefault(carNumber,0) + spendingTime);
            }
        }
        
        // 출차 찍히지 않은 시간 계산
        int lastTime = 23*60 + 59;
        for(String leftCarNumber:parkStatusMap.keySet()) {
            int inTime = parkStatusMap.get(leftCarNumber);
            int spendingTime = lastTime - inTime;
            timeMap.put(leftCarNumber,timeMap.getOrDefault(leftCarNumber,0) + spendingTime);
        }
        
        // 요금계산
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:timeMap.entrySet()){
            String carNumber = entry.getKey();
            int spendingTime = entry.getValue();
            
            // 기본 시간보다 적게 체류한 경우
            if(spendingTime <= basicTime) {
                list.add(basicPrice);
            } else {
                // 기본 시간보다 많이 체류한 경우
                int totalPrice = basicPrice;
                totalPrice += ((spendingTime - basicTime) + unitTime - 1) / unitTime * unitPrice;
                list.add(totalPrice);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    static int getTime(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
}