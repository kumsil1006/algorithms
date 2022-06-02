// 백준 N번째 수
import java.util.*;

class Main {
  public void solution(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i : nums) {
      if(i == 0 && pq.isEmpty()) {
        System.out.println(0);
        } else if(i == 0) {
        int n = pq.poll();
        System.out.println(n);
      } else {
        pq.add(i);
      }
    } 
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    int n = kb.nextInt();
    int[] numbers = new int[n];
    
    for(int i = 0; i < n; i++) {
      numbers[i] = kb.nextInt()  ;
    }

    T.solution(numbers);
  }
}