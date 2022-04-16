// 3. 최대점수 구하기(DFS)
import java.util.*;

public class Main {
  static int n, m, max;
  static int[] ch;
  static int[][] arr;
  
  public void DFS(int v) {
    if(v == n+1) {
      int time = 0;
      int score = 0;
      for(int i = 1; i <= n; i++) {
        if(ch[i] == 1) {
          time += arr[i][1];
          score += arr[i][0];
        }
      }
      if(time <= m && score > max) {
        max = score;
      }
    } else {
      ch[v] = 1;
      DFS(v+1);

      ch[v] = 0;
      DFS(v+1);
    }
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    n = in.nextInt();
    m = in.nextInt();
    max = 0;
    
    ch = new int[n+1];
    arr = new int[n+1][2];
    
    for(int i = 1; i <= n; i++) {
      arr[i][0] = in.nextInt();
      arr[i][1] = in.nextInt();
    }

    ch[1] = 1;
    t.DFS(1);
    System.out.println(max);
  }
}