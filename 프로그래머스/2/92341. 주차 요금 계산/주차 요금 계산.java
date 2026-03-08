import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answerList = new ArrayList<>();
        
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> carMap = new TreeMap<>();
        for(String record:records) {
            StringTokenizer st = new StringTokenizer(record);
            String[] recordTimeStr = st.nextToken().split(":");
            int recordTime = Integer.parseInt(recordTimeStr[0]) * 60 + Integer.parseInt(recordTimeStr[1]);
            String carNumber = st.nextToken();
            String action = st.nextToken();
            
            if("IN".equals(action)) {
                recordMap.put(carNumber, recordTime);
            } else {
                int inTime = recordMap.get(carNumber);
                int spendingTime = recordTime - inTime;
                recordMap.remove(carNumber);
                
                carMap.put(carNumber, carMap.getOrDefault(carNumber,0) + spendingTime);
            }
            
        }
        // 만약 남아있는 차가 있다면, 23:59에 출차로 간주
        int endTime = 23*60 + 59;
        for(String carNumber:recordMap.keySet()) {
            int inTime = recordMap.get(carNumber);
            int spendingTime = endTime - inTime;
            carMap.put(carNumber, carMap.getOrDefault(carNumber,0) + spendingTime);
        }
        
        for(String key : carMap.keySet()) {
            System.out.printf("carNumber: %s, spendingTime: %d \n",key, carMap.get(key));
            int totalSpendingTime = carMap.get(key);
            answerList.add(getTotalPrice(totalSpendingTime, basicTime, basicPrice, unitPrice, unitTime));
        }
            
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int getTotalPrice(int spendingTime, int basicTime, int basicPrice, int unitPrice, int unitTime) {
        int totalPrice = basicPrice;
        
        if(spendingTime<=basicTime) {
            return totalPrice;
        }
        
        int overTime = spendingTime - basicTime;
        
        // 나눗셈할 때 1안넘으면 자동으로 올림처리 되던가? -> 안되는걸로 확인 
        totalPrice += (overTime/unitTime) * unitPrice;
        
        if(overTime%unitTime > 0)
        totalPrice += unitPrice;
        
        return totalPrice;
    }
    
    
}