import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기문제3 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] sumlist = new long[suNo+1];
        sumlist[0] = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<suNo+1; i++){
            sumlist[i] += sumlist[i-1]+Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int i =1; i<quizNo+1; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstNum = Integer.parseInt(stringTokenizer.nextToken());
            int lastNum = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sumlist[lastNum]-sumlist[firstNum-1]);
        }

    }

}
