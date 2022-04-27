// 백준 2178번 미로탐색
// https://www.acmicpc.net/problem/2178
// 문제 풀이 방법: BFS
import java.util.*;

public class Main {
  static int n, m;
  static int[][] ch, maze;
  
  public int BFS(int x, int y) {
    Pair[] move = {new Pair(1, 0), new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1)};
    Pair p = new Pair(x, y);
    Queue<Pair> q = new LinkedList<>();
    
    q.add(p);
    
    while(!q.isEmpty()) { 
      int len = q.size();
      for(int i = 0; i < len; i++) {
        Pair pair = q.poll();
        for(int j = 0; j < 4; j++) {
          Pair next = move[j];
          int nx = pair.get(0) + next.get(0);
          int ny = pair.get(1) + next.get(1);
          if(nx <= n+1 && ny <= m+1 && nx > 0 && ny > 0 && ch[nx][ny] == 0 && maze[nx][ny] == 1) {
            q.add(new Pair(nx, ny));
            ch[nx][ny] = ch[pair.get(0)][pair.get(1)]+1;
          }
        }
      }
    }
    return 0;
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();

    n = in.nextInt();
    m = in.nextInt();
    maze = new int[n+2][m+2];
    ch = new int[n+2][m+2];
    
    for(int i = 1; i <= n; i++) {
      String str = in.next();
      char[] c = str.toCharArray();
      for(int j = 0; j < c.length; j++) {
        maze[i][j+1] = Character.getNumericValue(c[j]);
      }
    }

    ch[1][1] = 1;  
    t.BFS(1, 1); // 출발 -> 1,1
    System.out.println(ch[n][m]);
  }
}
// class를 public으로 선언하면 Pair.java에 선언해야함!
class Pair {
  int x, y;
  public Pair(int a, int b) {
    x = a;
    y = b;
  }
  public int get(int n) {
    return n == 0 ? x : y;
  }
}