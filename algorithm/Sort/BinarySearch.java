// 8. 이분검색
import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int result = -1, tmp = 0;
        int s = 0, e = n-1;
        Arrays.sort(arr);

        while(s <= e) {
            tmp = (e + s) / 2;
            //System.out.print("\n" + s + " " + e + " " + tmp + " " + arr[tmp]);
            if(arr[tmp] > k) e = tmp-1;
            else if(arr[tmp] == k) return tmp+1;
            else s = tmp+1;
        }

        return result;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main t = new Main();
        int n = in.nextInt();
        int k  = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
        return ;
    }
}