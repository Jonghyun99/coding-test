import java.util.*;
class Solution {
    
    static class Node {
        String word;
        int deepth;
        Node(String word, int deepth) {
            this.word = word;
            this.deepth = deepth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited);
    }
    
    static int bfs(String begin, String target, String[] words, boolean[] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if(now.word.equals(target)) {
                return now.deepth;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && checkDiffer(now.word,words[i])) {
                    q.add(new Node(words[i], now.deepth+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    static boolean checkDiffer(String a, String b) {
        int cnt=0;
        System.out.println("check: a:" + a +", b: " + b);
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }
        if(cnt+1==a.length()) {
            return true;
        }
        return false;
    }
}