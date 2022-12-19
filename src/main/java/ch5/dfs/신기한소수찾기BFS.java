package ch5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 신기한소수찾기BFS {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        bfs(2,1);
        bfs(3,1);
        bfs(5,1);
        bfs(7,1);

    }

    private static void bfs(int index,int depth) {

        Queue<Integer> queue = new LinkedList<>();

        if(depth == N && isPrime(index)){
            System.out.println(index);
            return;
        }

        queue.add(index);

        while(!queue.isEmpty()){

            Integer poll = queue.poll();
            depth = (int)(Math.log10(poll)+1);
            if(isPrime(poll) && depth == N){
                System.out.println(poll);
                continue;
            }

            for(int i =0; i<5;i++){
                int k = poll;
                poll = poll*10 +(2*i+1);
                if(isPrime(poll)){
                    queue.add(poll);
                }
                poll = k;
            }

        }

    }

    private static boolean isPrime(int index){
        for(int i = 2; i<(index/2); i++){
            if((index%i) == 0){
                return false;
            }
        }
        return true;
    }

}
