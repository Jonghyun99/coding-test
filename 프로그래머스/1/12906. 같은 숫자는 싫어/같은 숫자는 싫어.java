import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int num:arr){
            if(list.size()==0) {
                list.add(num);
                continue;
            }            
            
            if(list.get(idx) != num) {
                list.add(num);
                idx++;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}