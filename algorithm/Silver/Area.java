// 백준 2583번 영역 구하기
// https://www.acmicpc.net/problem/2583
import java.util.*;

class Main {
  static int m, n, cnt;
  static int[][] map;
  static List<Integer> list;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    m = sc.nextInt();
    n = sc.nextInt();
    map = new int[m][n];
    list = new ArrayList<>();
    
    int k = sc.nextInt();
    
    Main M = new Main();
    
    for(int t = 0; t < k; t++) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      for(int i = x1; i < x2; i++) {
        for(int j = y1; j < y2; j++) {
          map[j][i] = 1;
        }
      }
    }

    M.solution();
    System.out.println(list.size());
    Collections.sort(list);
    for(int i : list) {
      System.out.print(i + " ");
    }
  }
  
  public void solution() {
    for(int i = 0; i < m; i++) {
      for(int j = 0 ; j < n; j++) {
        if(map[i][j] == 0) {
          map[i][j] = 2;
          cnt = 1;
          DFS(i, j);
          list.add(cnt);
        }
      }
    }
  }
  
  public void DFS(int x, int y) {
    int[] moveX = { 1, -1, 0, 0 };
    int[] moveY = { 0, 0, -1, 1 };

    for(int i = 0; i < 4; i++) {
      int nx = x + moveX[i];
      int ny = y + moveY[i];

      if(nx < 0 || ny < 0 || nx >= m || ny >= n || map[nx][ny] != 0) {
        continue;
      }
      cnt++;
      map[nx][ny] = 2;
      DFS(nx, ny);
    }
  }
}