package ch5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기 {

    private static int[][] coordinateSystem;
    private static boolean[][] visited;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        coordinateSystem = new int[y+2][x+2];
        visited = new boolean[y+2][x+2];
        result = 1;

        for (int i =1; i<=y; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j<=x; j++){
                coordinateSystem[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }

        bfs(x,y);
        System.out.println(result);

    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1,1));
        visited[1][1] = true;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.x == x && poll.y == y){
                result = poll.depth;
                return;
            }
            for(int i =0; i<4; i++){
                if(i == 0){
                    int newY = poll.y + 1;
                    int newX = poll.x;
                    if(coordinateSystem[newY][newX] == 1 && !visited[newY][newX]){
                        visited[newY][newX] = true;
                        queue.add(new Node(newX,newY, poll.depth+1));
                    }
                } else if(i == 1){
                    int newY = poll.y - 1;
                    int newX = poll.x;
                    if(coordinateSystem[newY][newX] == 1 && !visited[newY][newX]){
                        visited[newY][newX] = true;
                        queue.add(new Node(newX,newY,poll.depth+1));
                    }
                } else if(i == 2){
                    int newY = poll.y;
                    int newX = poll.x + 1;
                    if(coordinateSystem[newY][newX] == 1 && !visited[newY][newX]){
                        visited[newY][newX] = true;
                        queue.add(new Node(newX,newY,poll.depth+1));
                    }
                } else{
                    int newY = poll.y;
                    int newX = poll.x - 1;
                    if(coordinateSystem[newY][newX] == 1 && !visited[newY][newX]){
                        visited[newY][newX] = true;
                        queue.add(new Node(newX,newY,poll.depth+1));
                    }
                }
            }
        }
    }

    static class Node{
        private int x;
        private int y;
        private int depth;

        public Node(int x, int y,int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

    }
}
