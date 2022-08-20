// 백준 14503번 로봇청소기
// https://www.acmicpc.net/problem/14503
import java.util.*;

class Main {
  static int[][] map;
  static int n, m;
  static Robot robot;
  static int result = 0;
  static int chk = 0;
  
  public static void main(String[] args) {
    Main M = new Main();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    int r = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    robot = new Robot(r, c, d);
    map = new int[n][m];
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    M.solution();
    System.out.println(result);
  }
  
  public void solution() {
    int c = robot.x;
    int r = robot.y;

    if(map[c][r] == 0) {
      map[c][r] = 2;
      result++;
    }

    search();
  }

  public void search() {
    if(chk < 4) {
      chk++;
      robot.rotate();
      if(robot.check()) {
        robot.go();
        chk = 0;
        solution();
        return;
      }
      search();
      return;
    }
    
    chk = 0;
    if(!robot.goBack()) {
      return;
    }
    solution();
  }
  
  static class Robot {
    int x, y, d;
    int[] moveX = { -1, 0, 1, 0 }; // 북 동 남 서
    int[] moveY = { 0, 1, 0, -1 };
    
    public Robot(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
    public void rotate() {
      // 왼쪽으로 회전
      this.d = this.d == 0 ? 3 : this.d - 1;
    }

    public boolean check() {
      int nx = this.x + moveX[this.d];
      int ny = this.y + moveY[this.d];
      if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
        return false;
      }
      if(map[nx][ny] != 0) {
        return false;
      }
      return true;
    }
    
    public int go() {
      int nx = this.x + moveX[this.d];
      int ny = this.y + moveY[this.d];
      this.x = nx;
      this.y = ny;
      return 0; // 성공
    }
    
    public boolean goBack() {
      int nx = this.x + moveX[this.d] * -1;
      int ny = this.y + moveY[this.d] * -1;
      if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1) {
        return false;
      }
      this.x = nx;
      this.y = ny;
      return true;
    }

    public String toString() {
      return this.x + " " + this.y + " " + this.d;
    }
  }
}