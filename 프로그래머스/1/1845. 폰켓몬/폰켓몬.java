import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // 가장 많은 종류의 포켓몬 구하기
        for(int num:nums) {
            map.put(num,1);
        }
        
        
        return Math.min(map.size(), nums.length/2);
    }
}