import java.util.*;

class Main {
  static boolean flag = false;
  public static void main(String[] args) {
    int[] input = new int[9];
    Main M = new Main();
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < 9; i++) {
      input[i] = sc.nextInt();
    }
    M.solution(input);
  }
  
  public void solution(int[] input) {
    DFS(input, new boolean[9], 0, 0, 7);
  }
  
  public boolean checkSum(List<Integer> out) {
    int result = 0;
    for(int i : out) {
      result += i;
    }
    return result == 100;
  }
  
  public void DFS(int[] input, boolean[] visited, int depth, int start, int r) {
    if(flag) {
      return;
    }
    if(depth == r) {
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < visited.length; i++) {
        if(visited[i]) {
          list.add(input[i]);
        }
      }
      if(checkSum(list)) {
        flag = true;
        Collections.sort(list);
        for(int i : list) {
          System.out.println(i);
        }
      }
      return;
    }

    for(int i = start; i < input.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        DFS(input, visited, depth+1, start+1, r);
        visited[i] = false;
      }
    }
  }
  
}