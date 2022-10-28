import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙구현하기 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_number = Math.abs(o1);
            int second_number = Math.abs(o2);
            if(first_number == second_number){
                return o1 > o2 ? 1 : -1;
            } else {
                return first_number - second_number;
            }
        });

        for(int i= 0; i<N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(queue.size() == 0 ){
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }
    }

}
