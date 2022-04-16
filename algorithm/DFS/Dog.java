// 2. 바둑이 승차(DFS)
import java.util.*;

public class Main {
    static int[] ch;
    static int c, n;
    static int answer = 0;
    static int[] arr;

    public void DFS(int v) {
      if(v == n+1) {
        // 종착점
        int sum = 0;
        for(int i = 1; i <= n; i++) {
          if(ch[i] == 1) {
            sum += arr[i];
          }
        }
        if(sum <= c && sum > answer) {
          answer = sum;
        }
      } else {
        ch[v] = 1;
        DFS(v+1);

        ch[v] = 0;
        DFS(v+1);
      }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main t = new Main();
        c = in.nextInt();
        n = in.nextInt();
        ch = new int[n+1];
        arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
          arr[i] = in.nextInt();
        }
        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);
        return ;
    }
}