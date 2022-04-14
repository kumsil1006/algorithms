// 경로 탐색(인접행렬)
import java.util.*;

class Main {
  static int answer = 0;
  static int n;
  static int m;
  static int[][] graph;
  static int[] ch;
  
  public void DFS(int v) {
      if(v == n) answer++;
      else {
        for(int i = 1; i <=n; i++) {
          // ch --> 이미 방문했는지 체크
          if(graph[v][i] == 1 && ch[i] == 0) {
            ch[i] = 1;
            DFS(i);
            ch[i] = 0; // back하면서 체크 해제해야 다른 경로 찾을 수 있음
          }
        }
      }
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    graph = new int[n+1][n+1];
    ch = new int[n+1];
    for(int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      graph[a][b] = 1; // 1이면 둘이 연결되어 있는 것!
    }
    ch[1] = 1;
    T.DFS(1);
    System.out.println(answer);
  }
}