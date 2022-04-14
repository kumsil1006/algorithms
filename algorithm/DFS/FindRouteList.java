// 경로 탐색(인접리스트)
// 정점이 너무 많으면 인접행렬이 비효율적임(메모리, 시간 낭비)
// 따라서, 인접리스트를 사용하여 문제를 해결할 수 있다.
import java.util.*;

class Main {
  static int n, m, answer = 0;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] ch;
  public void DFS(int v) {
    if(v==n) answer++;
    else {
      // v의 다음 정점(v번 ArrayList 내용 살핌)
      for(int nv : graph.get(v)) {
        if(ch[nv] == 0) {
          ch[nv] = 1;
          DFS(nv);
          ch[nv] = 0;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    graph = new ArrayList<>();
    for(int i = 0; i <=n; i++) {
      graph.add(new ArrayList<Integer>()); // 객체생성!
    }
    ch = new int[n+1];
    for(int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      graph.get(a).add(b);
    }
    ch[1] = 1;
    T.DFS(1);
    System.out.println(answer);
  }
}