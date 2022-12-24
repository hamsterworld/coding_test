package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실배정하기3 {
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

//        PriorityQueue<Time> TimeQueue = new PriorityQueue<>((t1,t2) -> {
//            int time = t1.startTime - t2.startTime;
//            if(time == 0){
//                return t1.endTime-t2.endTime;
//            }
//            return time;
//        } );

        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Time> TimeQueue = new LinkedList<>();
        int k = 0;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            if(startTime == endTime){
                map.put(k,startTime);
                k++;
                continue;
            }
            TimeQueue.add(new Time(startTime,endTime));
        }

        Time poll = TimeQueue.poll();
        int startTime = poll.startTime;
        int endTime = poll.endTime;
        int size = map.size();
        int count = 0;
        int r = 0;
        while(size != count){
            count ++;
            if(startTime <= map.get(r) && endTime > map.get(r)){
                continue;
            }
            r++;
        }

        for (int i =0; i<N-1; i++) {
            Time poll1 = TimeQueue.poll();
            int secondStartTime = poll1.startTime;
            int secondEndTime = poll1.endTime;

            // 시간이 겹칠때
            if (secondStartTime >= startTime && secondStartTime < endTime) {
//                int secondEndTime = poll1.endTime;
//                int firstTimeLength = endTime - startTime;
//                int secondTimeLength = secondEndTime - secondStartTime;
//                if (firstTimeLength > secondTimeLength) {
//                    startTime = secondStartTime;
//                    endTime = secondEndTime;
//                }
            } else if(secondEndTime >= startTime && secondEndTime < endTime){

            } else {
                startTime = secondStartTime;
                endTime = poll1.endTime;
                result += 1;
            }
        }

        System.out.println(result);
    }

    static class Time{
        private final int startTime;
        private final int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
