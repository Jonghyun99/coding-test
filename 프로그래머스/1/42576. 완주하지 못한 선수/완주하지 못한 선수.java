import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String player:participant) {
            map.put(player, map.getOrDefault(player,0) + 1);
        }
        
        for(String player:completion) {
            map.put(player, map.get(player)-1);
        }
        
        for(Map.Entry<String, Integer> entryMap:map.entrySet()) {
            int cnt = entryMap.getValue();
            if(cnt != 0) return entryMap.getKey();
        }
        return "0";
    }
}