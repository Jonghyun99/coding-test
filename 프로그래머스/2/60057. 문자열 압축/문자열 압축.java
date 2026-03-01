class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for(int i=1; i<=s.length() / 2 ;i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,i);
            int count=1;
            
            for(int j=i; j<s.length(); j+=i) {
                int end = Math.min(j+i, s.length()); // 포인트 indexOutof 방지
                String curr = s.substring(j,end);
                
                if(prev.equals(curr)) {
                    count++;
                } else {
                    if(count>=2) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    
                    prev = curr;
                    count=1;
                }
            }
            if(count>=2) {
                sb.append(count);
            }
            sb.append(prev);
            minLength = Math.min(minLength, sb.toString().length());
        }
        return minLength;
    }
}