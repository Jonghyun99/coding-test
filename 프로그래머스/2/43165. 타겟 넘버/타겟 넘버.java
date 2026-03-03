class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    static int dfs(int[] numbers, int target, int index, int currentSum) {
        if(index == numbers.length) {
            return (currentSum == target) ? 1 : 0;
        }
        
        return dfs(numbers, target, index+1, currentSum + numbers[index])
            + dfs(numbers, target, index+1, currentSum - numbers[index]);
    }
}