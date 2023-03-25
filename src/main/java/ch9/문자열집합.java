package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node root = new Node();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String message = st.nextToken();
            Node now = root;
            for(int j = 0;j<message.length(); j++){
                char c = message.charAt(j);
                if(now.next[c-'a'] == null){
                    now.next[c-'a'] = new Node();
                }
                now = now.next[c-'a'];
                if(j == message.length()-1){
                    now.end = true;
                }
            }
        }

        int count = 0;

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String message = st.nextToken();
            Node now = root;
            for(int j = 0;j<message.length(); j++){
                char c = message.charAt(j);
                if(now.next[c-'a'] == null){
                    break;
                }
                now = now.next[c-'a'];
                if(j == message.length()-1 && now.end){
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static class Node{
        Node[] next = new Node[26];
        boolean end;

        public void setEnd(boolean end) {
            this.end = end;
        }

        public Node[] getNext() {
            return next;
        }

        public boolean isEnd() {
            return end;
        }
    }
}
