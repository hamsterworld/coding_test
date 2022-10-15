import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] longsumlist = new long[N+1];
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=N;i++){
            longsumlist[i] += longsumlist[i-1] + Integer.parseInt(st.nextToken());
        }
        long[] longlist = new long[M];
        for(int i = 1; i<=N; i++){
            int r = (int)(longsumlist[i]%M);
            if(r == 0) ans++;
            longlist[r]++;
        }
        for(int i = 0; i<M; i++){
            if(longlist[i]>1){
                ans += ((longlist[i]*(longlist[i]-1))/2);
            }
        }

        System.out.println(ans);
    }
}