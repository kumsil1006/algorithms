
import java.util.*;

public class Main {
  public String solution(int[] nums) {
    Arrays.sort(nums);

    if(nums[2] >= nums[0] + nums[1]) {
        return "Invalid";
    }
    if(nums[0] == nums[1] && nums[1] == nums[2]) {
      return "Equilateral";
    }
    if(nums[0] != nums[1] && nums[2] != nums[0] && nums[2] != nums[1]) {

      return "Scalene";
    }

    return "Isosceles";
  }
  
  public static void main(String[] args) {
    Main m = new Main();
    Scanner kb = new Scanner(System.in);

    while(true) {
      int[] t = new int[3];
      boolean stop = true;
      for(int i = 0; i < 3; i++) {
        t[i] = kb.nextInt();
        if(t[i] != 0) {
          stop = false;
        }
      }
      if(stop) {
        break;
      }
      
      System.out.println(m.solution(t)); 
    }
  }
}