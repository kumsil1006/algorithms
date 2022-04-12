// 5. 연속된 자연수의 합
import java.util.*;

public class Main {
  public int solution(int n) {
    int cnt = 0, sum = 0, rt = 2 , lt = 1;
    sum = lt;
    
    while(rt < n) {
      sum += rt++;
      if(sum >= n) {
        if(sum == n) cnt++;
        sum = 0;
        lt++;
        rt = lt+1;
      }
    }

    return cnt;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    
    int result = m.solution(n);
    System.out.println(result);
    return ;
  }
}