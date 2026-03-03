class Solution {
    public int solution(String s) {
        if(s.length()==1) return 1;
        
        int minLength = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String base = s.substring(0,i);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<s.length(); j+=i) {
                int lastIndex = Math.min(s.length(), i+j);
                String curr = s.substring(j,lastIndex);
                
                if(base.equals(curr)) {
                    count++;
                } else {
                    if(count>1) {
                        sb.append(count);
                    }
                    sb.append(base);
                    base=curr;
                    count=1;
                }
            }
            if(count>1) {
                sb.append(count);
            }
            sb.append(base);
            
            minLength = Math.min(sb.length(),minLength);
        }
        
        
        return minLength;
    }
}