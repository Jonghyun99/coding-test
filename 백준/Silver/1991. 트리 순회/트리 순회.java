import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        char value;
        Node left;
        Node right;
        Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static Node[] tree = new Node[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<26; i++){
            tree[i] = new Node((char) ('A' +i));
        }

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0); // charAt(0) 하는 이유는?
            char left = st.nextToken().charAt(0); // charAt(0) 하는 이유는?
            char right = st.nextToken().charAt(0); // charAt(0) 하는 이유는?

            if(left!='.') {
                tree[parent-'A'].left = tree[left - 'A'];
            }
            if(right!='.') {
                tree[parent-'A'].right = tree[right-'A'];
            }
        }

        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);
        System.out.println(sb);


    }

    // 전위 순회 (Root -> Left -> Right)
    static void preOrder(Node node) {
        if(node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위순회 (Left -> Root -> Right)
    static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    // 후위 순회 (Left -> Right -> Root)
    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}