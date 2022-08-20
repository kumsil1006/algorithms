// 백준 ATM
// https://www.acmicpc.net/problem/11399
import java.util.*;

class Main {
  public int solution(int n, int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    int curr = 0;

    for(int i : nums) {
      curr += i;
      result += curr;
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    int n = kb.nextInt();
    int[] numbers = new int[n];
    
    for(int i = 0; i < n; i++) {
      numbers[i] = kb.nextInt();
    }

    System.out.println(T.solution(n, numbers));
  }
}