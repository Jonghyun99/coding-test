import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int as = 0;
        int bs = 0;
        int cs = 0;
        
        for(int i=0; i<answers.length; i++){
            if(a[i%a.length] == answers[i]) as++;
            if(b[i%b.length] == answers[i]) bs++;
            if(c[i%c.length] == answers[i]) cs++;
        }
        int maxCnt = 0;
        int winner = 0;
        List<Integer> list = new ArrayList<>();
        
        maxCnt = Math.max(maxCnt,as);
        maxCnt = Math.max(maxCnt,bs);
        maxCnt = Math.max(maxCnt,cs);
        if(maxCnt == as) 
            list.add(1);
        if(maxCnt == bs) 
            list.add(2);
        if(maxCnt == cs) 
            list.add(3);
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}