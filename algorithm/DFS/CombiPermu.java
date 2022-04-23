// 순열&조합 구하기
import java.util.*;

public class Main {
    static int n, m;
    static int[] combi, permu, ch;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main t = new Main();
        n = in.nextInt();
        m = in.nextInt();
        combi = new int[m];
        permu = new int[m];
        ch = new int[n];

        t.combination(0,1);
        System.out.println("----------------");
        t.permutation(0);
    }
    // 조합
    public void combination(int L, int s) {
        if(L == m) {
            for(int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                combi[L] = i;
                combination(L+1, i+1);
            }
        }
    }
  // 순열
    public void permutation(int L) {
        if(L == m) {
            for(int i : permu) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    permu[L] = i;
                    ch[i] = 1;
                    permutation(L+1);
                    ch[i] = 0;
                }
            }

        }
    }

}