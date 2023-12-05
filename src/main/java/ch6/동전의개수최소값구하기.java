package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전의개수최소값구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int targetAmount = Integer.parseInt(st.nextToken());

        int[] coinValues = new int[coinCount];

        for(int i=0; i<coinCount; i++){
            st = new StringTokenizer(br.readLine());
            int coinValue = Integer.parseInt(st.nextToken());
            coinValues[i] = coinValue;
        }

        int result = 0;
        int remainder = targetAmount;
        for(int i=coinValues.length-1; i>=0; i--){
            if(remainder == 0){
                break;
            }
            int coinValue = coinValues[i];
            if(coinValue <= remainder){
                int calculatedCount = remainder / coinValue;
                result += calculatedCount;
                remainder = remainder % coinValue;
            }
        }

        System.out.println(result);
        
    }
}
