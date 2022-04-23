// 백준 11724 연결 요소의 개수
// https://www.acmicpc.net/problem/11724

import java.util.*;

class Main {
  static int n, m, cnt, visited;
  static int[] ch;
  static List<List<Integer>> graph;
  
  public void BFS(int v) {
    if(v == n) {
      return;      
    } else {
      Queue<Integer> q = new LinkedList<>();
      q.add(v);

      while(!q.isEmpty()) {
        int nv = q.poll();
        List<Integer> list = graph.get(nv);
        for(int i = 0; i < list.size(); i++) {
          int a = list.get(i);
          if(ch[a] == 0) {
            ch[a] = 1;
            q.add(a);  
            visited++;
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    
    n = in.nextInt();
    m = in.nextInt();

    cnt = 0;
    visited = 0;
    
    ch = new int[n+1];
    graph = new ArrayList<>();

    for(int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for(int i = 1; i <= n; i++) {
      if(ch[i] == 0) {
        ch[i] = 1;
        t.BFS(i);
        cnt++;
        visited++;
      }
    }
    
    System.out.println(cnt);
  }
}