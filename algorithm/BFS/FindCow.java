// 8. 송아지 찾기1(BFS:상태트리탐색)
// 최단 거리 알고리즘
// 이동 방법이 3가지이므로, 방문하는 노드에서 각각 3가지 자식노드를 생성하여 방문함 (한 번 방문한 데는 들어갈 필요 없으니 추가로 방문하지 않는다)
import java.util.*;

public class Main {
  int answer = 0;
  int[] dis = { 1, -1, 5 };
  int[] ch;
  Queue<Integer> q = new LinkedList<>();
  
  public int BFS(int s, int e) {
    ch = new int[10001];
    ch[s] = 1; // start 지점 방문
    q.add(s);
    int L = 0; // 거리

    while(!q.isEmpty()) {
      int len = q.size();
      for(int i = 0; i < len; i++) {
        int x = q.poll();
        if(x == e) return L;
        for(int j = 0; j < 3; j++) {
          int nx = x + dis[j]; // 가는 방법에 따른 자식 노드 찾기
          // 유효한 범위에 있고, 방문한 적 있는지 체크
          if(nx>=1 && nx <= 10000 && ch[nx] == 0) {
              ch[nx] = 1;
              q.add(nx);
          }
        }
      }
      L++;
    }
    return 0;
  }
  
  public static void main(String[] args) {
    Main m = new Main();
    Scanner kb = new Scanner(System.in);
    int s = kb.nextInt();
    int e = kb.nextInt();
    System.out.println(m.BFS(s, e));
  }
}