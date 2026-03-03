import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> chatMap = new HashMap<>();
        int changeCnt = 0;
        for(String str:record){
            String[] input = str.split(" ");
            
            if(input[0].equals("Enter")) {
                chatMap.put(input[1],input[2]);
            } else if(input[0].equals("Change")) {
                String uid = input[1];
                String nextNickName = input[2];
                chatMap.put(uid, nextNickName);
                changeCnt++;
            }
        }
        String[] answer = new String[record.length-changeCnt];
        int ansIdx = 0;
        for(int i=0; i<record.length; i++) {
            String[] input = record[i].split(" ");
            if(input[0].equals("Enter")) {
                answer[ansIdx] = chatMap.get(input[1]) +"님이 들어왔습니다.";
                ansIdx++;
            } else if(input[0].equals("Leave")) {
                answer[ansIdx] = chatMap.get(input[1]) +"님이 나갔습니다.";
                ansIdx++;
            }
        }        
        return answer;
    }
}