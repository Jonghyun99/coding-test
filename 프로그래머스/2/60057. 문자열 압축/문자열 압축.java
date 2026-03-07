class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for(int i=1; i<=s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            String curr =  s.substring(0,i);
            int count = 1;
            for(int j=i; j<s.length(); j+=i) {
                int lastIndex = Math.min(s.length(), j+i);
                String next = s.substring(j,lastIndex);
                if(curr.equals(next)) {
                    count++;
                } else {
                    if(count>=2){
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(curr);
                }
                curr = next;
            }
            if(count>=2) {
                sb.append(count);
            }
            sb.append(curr);
            
            minLength = Math.min(minLength, sb.length());
        }
        return minLength;
    }
}