// 백준 N번째 큰 수
// https://www.acmicpc.net/problem/2075
import java.util.*;

class Main {
  public int solution(int n, int[][] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int result = -1;
    
    for(int i = 0 ; i< n; i++) {
      for(int j = 0; j < n; j++) {
        pq.add(nums[i][j]);
      }
    }
    
    for(int i = 0; i < n; i++) {
      result = pq.poll();
    }

    return result;
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    int n = kb.nextInt();
    int[][] numbers = new int[n][n];
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        numbers[i][j] = kb.nextInt();
      }
    }

    System.out.println(T.solution(n, numbers));
  }
}