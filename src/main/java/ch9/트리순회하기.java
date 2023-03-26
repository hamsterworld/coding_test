package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회하기 {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        tree = new int[26][2];
        for(int i =0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
            String list = br.readLine();
            String[] chars = list.split(" ");
            int i1 = chars[0].charAt(0) - 'A';
            if(chars[1].charAt(0) == '.'){
                tree[i1][0] = -1;
            } else {
                tree[i1][0] = chars[1].charAt(0) - 'A';
            }
            if(chars[2].charAt(0) == '.'){
                tree[i1][1] = -1;
            } else {
                tree[i1][1] = chars[2].charAt(0) - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int i) {
        if(i == -1){
            return;
        }
        System.out.print((char) (i + 'A'));
        preOrder(tree[i][0]);
        preOrder(tree[i][1]);
    }
    private static void inOrder(int i) {
        if(i == -1){
            return;
        }
        inOrder(tree[i][0]);
        System.out.print((char) (i + 'A'));
        inOrder(tree[i][1]);
    }
    private static void postOrder(int i) {
        if(i == -1){
            return;
        }
        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        System.out.print((char) (i + 'A'));
    }
}
