import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속된자연수의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int startindex = 1;
        int endindex = 1;
        int sum = 1;
        int count = 1;

        while(endindex != N){
            if(sum < N){
                endindex++;
                sum += endindex;
            } else if(sum > N){
                sum -= startindex;
                startindex++;
            } else {
                count++;
                endindex++;
                sum += endindex;
            }

        }

        System.out.println(count);
    }
}
