import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int cmdIdx = 0;
        for(int[] command:commands) {
            int start = command[0];
            int end = command[1];
            int targetNum = command[2]-1;
            List<Integer> tempList = new ArrayList<>();
            for(int i=start-1; i<end; i++) {
                tempList.add(array[i]);
            }
            Collections.sort(tempList);
            answer[cmdIdx++] = tempList.get(targetNum);
        }
        
        return answer;
    }
}