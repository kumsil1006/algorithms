// 백준  1012 유기농 배추
// https://www.acmicpc.net/problem/1012
import java.util.*;

class Main {
  static int[][] ch, cabbage;
  static int m, n, k, answer;

  public void DFS(int x, int y) {
    int[] moveX = { 1, 0, -1, 0 };
    int[] moveY = { 0, 1, 0, -1 };

    for(int i = 0; i < 4; i++) {
      int nx = x + moveX[i];
      int ny = y + moveY[i];

      if(nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] != 1 && cabbage[nx][ny] == 1) {
        ch[nx][ny] = 1;
        DFS(nx, ny);
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    int T = in.nextInt();

    for(int r = 0; r < T; r++) {
      answer = 0;
      n = in.nextInt();
      m = in.nextInt();
      k = in.nextInt();
      
      cabbage = new int[n][m];
      ch = new int[n][m];
      
      for(int i = 0; i < k; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
  
        cabbage[x][y] = 1;
      }      
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          if(cabbage[i][j] == 1 && ch[i][j] != 1) {
            ch[i][j] = 1;
            answer++;
            t.DFS(i, j);
          }
        }
      }
      System.out.println(answer);
    }
    
  }
}