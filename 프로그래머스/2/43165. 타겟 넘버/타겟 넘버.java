class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    static int dfs(int deepth, int currentSum, int[] numbers, int target) {
        if(deepth == numbers.length) {
            if(currentSum == target) return 1;
            else return 0;
        }
            
        return dfs(deepth+1, currentSum + numbers[deepth], numbers, target) 
            + dfs(deepth+1, currentSum - numbers[deepth], numbers, target);
    }
}