package ch5.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] coordination = new int[N + 2][M + 2];
        boolean[][] visited = new boolean[N + 2][M + 2];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j<M; j++){
                coordination[i][j+1] = Integer.parseInt(line.substring(j,j+1));
            }
        }



        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(1,1,1);
        queue.add(node);
        visited[1][1] = true;

        while(!queue.isEmpty()){

            Node foundedNode = queue.poll();
            if(foundedNode.x == N && foundedNode.y == M){
                System.out.println(foundedNode.depth);
                break;
            }

            int x1 = foundedNode.x+1;
            int y1 = foundedNode.y;
            Node node1 = new Node(x1, y1, foundedNode.depth + 1);
            if(coordination[x1][y1] == 1 && !visited[x1][y1]){
                visited[x1][y1] = true;
                queue.add(node1);
            }

            int x2 = foundedNode.x-1;
            int y2 = foundedNode.y;
            Node node2 = new Node(x2, y2, foundedNode.depth + 1);
            if(coordination[x2][y2] == 1 && !visited[x2][y2]){
                visited[x2][y2] = true;
                queue.add(node2);
            }

            int x3 = foundedNode.x;
            int y3 = foundedNode.y+1;
            Node node3 = new Node(x3, y3, foundedNode.depth + 1);
            if(coordination[x3][y3] == 1 && !visited[x3][y3]){
                visited[x3][y3] = true;
                queue.add(node3);
            }

            int x4 = foundedNode.x;
            int y4 = foundedNode.y-1;
            Node node4 = new Node(x4, y4, foundedNode.depth + 1);
            if(coordination[x4][y4] == 1 && !visited[x4][y4]){
                visited[x4][y4] = true;
                queue.add(node4);
            }

        }

    }

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x,int y,int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
