import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};
    static int[][] board;
    static boolean[][] visited;
    static int oRow, oCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        oRow = Integer.parseInt(st.nextToken());
        oCol = Integer.parseInt(st.nextToken());

        board = new int[oRow][oCol];
        visited = new boolean[oRow][oCol];
        
        for(int i=0; i<oRow; i++){
            String str = br.readLine();
            for(int j=0; j<oCol; j++){
                board[i][j] = str.charAt(j)-'0';
            }
        }
        BFS(0, 0);

        System.out.println(board[oRow-1][oCol-1]);
    }

    static void BFS(int row, int col) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(row, col));
        visited[row][col] = true;
        while(!q.isEmpty()) {
            Point nowPoint = q.poll();
            int nowRow = nowPoint.row;
            int nowCol = nowPoint.col;
            for(int i=0; i<4; i++){
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                if(check(nextRow, nextCol)) {
                    q.add(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                    board[nextRow][nextCol] = board[nowRow][nowCol] + 1;
                }
                
            }
        }
    }

    static boolean check(int row, int col) {
        if(row < 0 || col < 0 || row >= oRow || col >= oCol) return false;
        if(board[row][col] == 0 || visited[row][col]) return false;
        return true;
    }

}