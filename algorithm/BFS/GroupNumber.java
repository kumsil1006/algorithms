// 백준 2667번 단지번호붙이기
// https://www.acmicpc.net/problem/2667
import java.util.*;

public class Main {
  static int[][] ch, map;
  static List<Integer> list;
  static int n, cnt;

  public void BFS(int x, int y) {
    int[] moveX = { 0, 1, 0, -1 };
    int[] moveY = { 1, 0, -1, 0 };
    
    Queue<Pair> q = new LinkedList<>();
    
    q.add(new Pair(x, y));
    cnt++;
    
    while(!q.isEmpty()) {
      Pair pair = q.poll();
      for(int i = 0; i < 4; i++) {
        int nx = pair.x + moveX[i];
        int ny = pair.y + moveY[i];

        if(nx <= n && ny <= n && nx > 0 && ny > 0 && ch[nx][ny] == 0 && map[nx][ny] == 1) {
          q.add(new Pair(nx, ny));
          ch[nx][ny] = 1;
          cnt++;
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    list = new ArrayList<>();
    
    n = in.nextInt();
    ch = new int[n+1][n+1];
    map = new int[n+1][n+1];
    
    for(int i = 1; i <= n; i++) {
      String str = in.next();
      char[] c = str.toCharArray();
      for(int j = 0; j < c.length; j++) {
        map[i][j+1] = Character.getNumericValue(c[j]);
      }
    }
    for(int i = 1; i <= n ; i++) {
      for(int j = 1; j <= n; j++) {
        if(ch[i][j] == 0 && map[i][j] == 1) {
          ch[i][j] = 1;
          t.BFS(i, j);
          if(cnt > 0) list.add(cnt); // 반례: 전부 다 1개씩 있을 때 처리 추가
          cnt = 0;
        }
      }
    }
    
    System.out.println(list.size());
    Collections.sort(list);
    for(int i : list) {
      System.out.println(i);
    }
  }
}
class Pair {
  int x, y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}