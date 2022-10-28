import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = scanner.nextInt();
        for(int i= 1;i<=N;i++){
            q.add(i);
        }
        boolean changeSwitch = true;

        while(q.size() != 1){
            if(changeSwitch){
                q.poll();
                changeSwitch = false;
            } else{
                Integer poll = q.poll();
                q.add(poll);
                changeSwitch = true;
            }
        }

        System.out.println(q.poll());

        System.gc();

    }

}
