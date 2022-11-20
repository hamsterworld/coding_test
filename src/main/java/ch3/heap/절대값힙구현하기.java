package ch3.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절대값힙구현하기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> list = new PriorityQueue<>(((o1, o2) -> {
            int abs = Math.abs(o1);
            int abs1 = Math.abs(o2);
            if(abs == abs1){
                return o1 > o2 ? 1 : -1;
            } else {
                return abs - abs1;
            }
        }));
        for(int i = 0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k == 0){
                if (list.isEmpty()){
                    System.out.println("0");
                }
                list.poll();
                System.out.println("뭘빼내");
            } else if(k != 0){
                list.add(k);
                System.out.println("스텍이든 뭐든 넣을거란말이지");
            }
        }

    }
}
