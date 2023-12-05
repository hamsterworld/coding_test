package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소값만들기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String message = st.nextToken();

        String[] splitedMessage = message.split("-");

        int result = 0;

        for(int i =0; i< splitedMessage.length; i++){
            int temp = mySum(splitedMessage[i]);
            if(i == 0){
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);

    }

    static int mySum(String splitedMessage){
        String[] split = splitedMessage.split("[+]");
        int result = 0;
        for (String value : split) {
            result += Integer.parseInt(value);
        }
        return result;
    }

}
