// 백준 2468번 안전 영역
// https://www.acmicpc.net/problem/2468
import java.util.*;

class Main {
  static int n, max, maxN;
  static int[][] ch, area;
  
  public void BFS(int x, int y, int m) {
    int[] moveX = { 1, 0, -1, 0 };
    int[] moveY = { 0, 1, 0, -1 };
    
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(x, y));

    while(!q.isEmpty()) {
      Pair p = q.poll();
      for(int i = 0; i < 4; i++) {
        int nx = p.x + moveX[i];
        int ny = p.y + moveY[i];

        if(nx > 0 && ny > 0 && nx <= n && ny <= n && ch[nx][ny] == 0 && area[nx][ny] > m) {
          ch[nx][ny] = 1;
          q.add(new Pair(nx, ny));
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);
    Main t = new Main();
    n = in.nextInt();
    area = new int[n+1][n+1];
    ch = new int[n+1][n+1];
    int cnt = 0;
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        int a = in.nextInt();
        if(a > maxN) maxN = a;
        area[i][j] = a;
      }
    }

    // 물의 높이가 0~입력의 최대까지라고 가정
    for(int i = 0; i <= maxN; i++) {
      for(int j = 1; j <= n; j++) {
        for(int k = 1; k <= n; k++) {
          if(ch[j][k] == 0 && area[j][k] > i) {
            ch[j][k] = 1;
            t.BFS(j, k, i);
            cnt++;
          }
        }
      }
      // 물의 높이가 증가할 때 max 값 설정 및 ch, cnt 초기화(새로 조사해야하니까)
      if(cnt > max) {
        max = cnt;
      }
      ch = new int[n+1][n+1];
      cnt = 0;
    }
    
    System.out.println(max);
  }
}
class Pair {
  int x, y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
