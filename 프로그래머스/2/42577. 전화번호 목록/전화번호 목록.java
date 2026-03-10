import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String n:phone_book) {
            map.put(n,1);
        }
        
        for(String n:phone_book){
            for(int i=1; i< n.length(); i++) {
                String preFix = n.substring(0,i);
                if(map.containsKey(preFix)){
                    return false;
                }
            }
        }
        return true;
        
    }
}