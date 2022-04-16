// 5. 동전교환
import java.util.*;

public class Main {
  static int n, m, min;
  static Integer[] types;
  static int[] ch;
  
  public void DFS(int v) {
    if(v == n) {
      int cnt = 0;
      int tmp = m;
      for(int i = 0; i < n; i++) {
        if(ch[i] == 1) {
          cnt += tmp / types[i];
          tmp = tmp % types[i];
          
          if(tmp == 0 && cnt < min) {System.out.println(types[i] + " " + cnt + " " + tmp);
            min = cnt;
          } 
        }
      }
    } else {
      ch[v] = 1;
      DFS(v+1);

      ch[v] = 0;
      DFS(v+1);
    }
  }
  
  public static void main(String[] args) {
    min = Integer.MAX_VALUE;
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    n = in.nextInt();
    types = new Integer[n];
    ch = new int[n];
    
    for(int i = 0; i < n; i++) {
      types[i] = in.nextInt();
    }
    m = in.nextInt();
    Arrays.sort(types, Collections.reverseOrder());
    ch[1] = 1;
    t.DFS(1);
    System.out.println(min);
  }
}