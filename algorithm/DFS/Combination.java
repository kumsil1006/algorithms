// 7. 조합의 경우 수 (메모이제이션)
import java.util.*;

public class Main {
    static int n, m, cnt;
    static int[] combi, ch;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main t = new Main();
        n = in.nextInt();
        m = in.nextInt();
        cnt = 0;
        combi = new int[m+1];
        ch = new int[n+1];

        t.combination(0,1);
        System.out.println(t.combination(0,1));
    }
    // 조합
    public int combination(int L, int s) {
      if(L == m) {
        // 마지막
        for(int i = 1; i <= n; i++) {
          if(ch[i] == 1) {
            System.out.print(i + " ");
          }
        }
        System.out.println();
        cnt++;
      } else if(n == s || s == 0) return 1;
        else if(s == 1) return n;
        else {
  
          ch[s] = 1;
          ch[s-1] = 1;
          cnt = cnt + combination(n-1, s-1) + combination(n-1, s);
          ch[s] = 0;
          ch[s-1] = 1;
      }
      return -1;
    }
}