// 백준  1012 유기농 배추
// https://www.acmicpc.net/problem/1012
import java.util.*;

class Main {
  static int[][] ch;
  static Map<Integer, List<Integer>> map;
  static int n, answer;

  public void DFS(int x, int y) {

  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Main t = new Main();
    map = new HashMap<>();
    int T = in.nextInt();

    for(int i = 0; i < T; i++) {
      n = in.nextInt(); // 편의점 수
      int[] start = new int[2];
      start[0] = in.nextInt()
      for(int j = 0; j < n; j++) {
        int x = in.nextInt();
        int y = in.nextInt();
        List<Integer> l = map.getOrDefault(x, new ArrayList<>());
        l.add(y);
        map.put(x, l);
      }
    }

    System.out.println(map);
    

    
  }
}