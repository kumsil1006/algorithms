// 백준 2644 촌수계산
// https://www.acmicpc.net/problem/2644
import java.util.*;

class Main {
  static int n, m, target1, target2;
  static int[] ch, answer;
  static boolean flag = false;
  static List<List<Integer>> graph;

  public void DFS(int v, int depth) {
    if(v == target1) {
      System.out.println(depth);
      flag = true;
      return;
    } else {
      List<Integer> list = graph.get(v);
      for(int i = 0; i < list.size(); i++) {
        int x = list.get(i);
        if(ch[x] == 0) {
          ch[x] = 1;
          DFS(x, depth+1);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    graph = new ArrayList<>();
    
    n = in.nextInt(); // 사람의 수
    target1 = in.nextInt(); // 촌수 계산해야 하는 사람1 
    target2 = in.nextInt(); // 촌수 계산해야 하는 사람2
    m = in.nextInt();
    
    ch = new int[n+1];
    answer = new int[n+1];
    
    for(int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }
    
    for(int i = 0; i <m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();

      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    
    t.DFS(target2, 0);
    if(!flag) System.out.println(-1);
  }
}