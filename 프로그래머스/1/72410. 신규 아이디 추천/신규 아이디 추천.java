class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id;
        
        // 1번조건
        answer = answer.toLowerCase();
        
        // 2번조건 replace랑 replaceAll 차이가 정규식차이였나?
        // 정규식 팁좀, 쓰긴 썻는데 헷갈리네 어떤거에 \\를 붙여야하는지도 모르겠다.
        answer = answer.replaceAll("[^a-z0-9\\-_\\.]","");
        
        // 3번조건
        answer = answer.replaceAll("\\.{2,}",".");        
        
        // 4번
        if(answer.startsWith(".")) answer=answer.substring(1,answer.length());
        
        if(!answer.isEmpty())
        if(answer.charAt(answer.length()-1) == '.') answer=answer.substring(0,answer.length()-1);
        
        // 5번조건
        if(answer.length() == 0) answer = "a";
        
        // 6번조건
        if(answer.length()>=16) {
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,14);
        }
        
        // 7번조건
        if(answer.length()<3) {
            while(answer.length()<3){
                answer+=answer.substring(answer.length()-1);
            }
        }
        
        
        System.out.println("answer: " + answer);
        
        return answer;
    }
}