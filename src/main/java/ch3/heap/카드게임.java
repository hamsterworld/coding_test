package ch3.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i =1;i<P+1;i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);

        }
        System.out.println(queue.poll());

    }

}
