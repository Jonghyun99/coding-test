class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    static int dfs(int index,int currentSum, int[] numbers, int target) {
        if(index == numbers.length) {
            if(currentSum==target) {
                return 1;
            }
            return 0;
        }
            
        return dfs(index+1, currentSum+numbers[index], numbers, target) + dfs(index+1, currentSum-numbers[index], numbers, target);
    }
}