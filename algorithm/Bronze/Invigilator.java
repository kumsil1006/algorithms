
import java.util.*;

public class Main {
  public long solution(int[] nums, int b, int c) {
    long cnt = 0;

    for(int i = 0; i < nums.length; i++) {
      int curr = nums[i] - b;
      cnt++; // b 감독관 1명
      
      if(curr <= 0) {
        continue;
      }
      
      if(curr % c == 0) {
        cnt += curr / c;
      } else {
        cnt = cnt + curr/c + 1;
      }
    }
    return cnt;
  }
  
  public static void main(String[] args) {
    Main m = new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    //int e = kb.nextInt();
    int[] nums = new int[n];
    for(int i = 0; i < n; i++) {
      nums[i] = kb.nextInt();
    }
    int b = kb.nextInt();
    int c = kb.nextInt();
    
    System.out.println(m.solution(nums, b, c));
  }
}