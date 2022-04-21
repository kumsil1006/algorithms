// 백준 2606 바이러스 (S3)
// https://www.acmicpc.net/problem/2606
import java.util.*;

public class Main {
  static List<List<Integer>> list = new ArrayList<>();
  static int n, m, cnt;
  static int[] ch;
  
  public void BFS(int v) {
    if(v == n) {
      return;
    } else {
      Queue<Integer> q = new LinkedList<>();
      q.add(v);
      while(!q.isEmpty()) {
        int nv = q.poll();
        List<Integer> l = list.get(nv); 
        for(int i = 0; i < l.size(); i++) {
          int b = l.get(i);
         
          if(ch[b] == 0) {
            q.add(b);
            ch[b] = 1;
            cnt++;
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    Main t = new Main();
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    m = s.nextInt();
    
    ch = new int[n+1];
    cnt = 0;
    
    for(int i = 0; i <= n; i++) {
      list.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < m; i++) {
      int a = s.nextInt();
      int b = s.nextInt();

      list.get(a).add(b);
      list.get(b).add(a);
    }
    ch[1] = 1;
    t.BFS(1);
    System.out.println(cnt);
  }
}