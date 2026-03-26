import java.util.*;
class Solution {
    
    // 1. 종류 마다 1개씩만 착용 가능
    // 2. 조합하여 나올 수 있는 경우의 수
    // -> 타입 별 개수를 저장한 뒤 조합
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] c:clothes) {
            String name = c[0];
            String type = c[1];
            
            map.put(type,map.getOrDefault(type,0)+1);
        }
        
        int maxCombinations = 1;
        for(int val:map.values()) {
            maxCombinations *= (val +1); // 해당 옷을 안입는 경우 포함
        }
        return maxCombinations-1;
    }
}