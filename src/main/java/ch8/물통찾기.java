package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물통찾기 {

    private static int[] sender = {0,0,1,1,2,2};
    private static int[] recevier = {1,2,0,2,1,2};
    private static boolean[][] visited;
    private static boolean[] answer;
    private static int[] vol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vol = new int[3];

        // now 값 초기화.
        for(int i = 0; i<3; i++){
            int i1 = Integer.parseInt(st.nextToken());
            vol[i] = i1;
        }


        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for(int i = 0; i<=200; i++){
            if(answer[i]){
                System.out.print(i+" ");
            }
        }

    }

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0,0));
        visited[0][0] = true;
        answer[vol[2]] = true;
        while(!queue.isEmpty()){
            AB poll = queue.poll();
            int A = poll.A;
            int B = poll.B;
            int C = vol[2] - (poll.A + poll.B);
            for(int i =0; i<6; i++){
                int[] next = {A,B,C};
                next[recevier[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if(next[recevier[i]] > vol[recevier[i]]){
                    next[sender[i]] = next[recevier[i]] - vol[recevier[i]];
                    next[recevier[i]] = vol[recevier[i]];
                }
                if(!visited[next[0]][next[1]]){
                    if(next[0] == 0){
                        answer[next[2]] = true;
                    }
                    visited[next[0]][next[1]] = true;
                    AB ab = new AB(next[0],next[1]);
                    queue.add(ab);
                }
            }
        }

    }

    static class AB{
        private int A;
        private int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
