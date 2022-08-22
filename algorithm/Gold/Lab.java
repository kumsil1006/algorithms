// 백준 14502 연구소
// https://www.acmicpc.net/problem/14502
import java.util.*;

class Main {
  static int n, m, safe, max;
  static int[][] map;
  static Queue<Pair> queue;
  int[] moveX = { 1, 0, -1, 0 };
  int[] moveY = { 0, 1, 0, -1 };
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Main M = new Main();
    queue = new LinkedList<>();
    
    n = sc.nextInt();
    m = sc.nextInt();
    
    map = new int[n][m];
    max = Integer.MIN_VALUE;
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    M.getArea(0);
    System.out.println(max);
  }
  
  public void BFS() {
    int[][] map2 = new int[n][m];
    
    // 배열 복사 및 bfs 준비(2인 애들 큐에 넣어놓기)
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        map2[i][j] = map[i][j];
        if(map2[i][j] == 2) {
          queue.add(new Pair(i, j));
        }
      }
    }

    while(queue.size() > 0) {
      Pair pair = queue.poll();

      for(int i = 0; i < 4; i++) {
        int nx = pair.x + moveX[i];
        int ny = pair.y + moveY[i];

        if(nx < 0 || nx >= n || ny < 0 || ny >= m || map2[nx][ny] != 0) {
          continue;
        }
        map2[nx][ny] = 2;
        queue.add(new Pair(nx, ny));
      }
    }

    safe = 0;

    // 안전 구역 넓이 계산
    for(int i =0 ; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(map2[i][j] == 0) {
          safe++;
        }
      }
    }
    
    if(max < safe) {
      max = safe;
    }
  }

  public void getArea(int cnt) {
    if(cnt == 3) {
      // 3개 됐을때 BFS로 2와 인접한 구간 2로 만들기
      BFS();
      return;
    }
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(map[i][j] == 0) {
          // 벽 세우고 백트래킹
          map[i][j] = 1;
          getArea(cnt+1);
          map[i][j] = 0;
        }
      }
    }
  }
  
  static class Pair {
    int x, y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public String toString() {
      return this.x + " " + this.y;
    }
  }
}