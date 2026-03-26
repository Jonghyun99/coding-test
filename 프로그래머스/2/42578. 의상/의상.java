import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> m = new HashMap<>();
        for(String[] c:clothes) {
            m.put(c[1], m.getOrDefault(c[1],0)+1);
        }
        
        int combo = 1;
        for(int v:m.values()) {
            combo *= v+1;
        }
        return combo-1;
    }
}