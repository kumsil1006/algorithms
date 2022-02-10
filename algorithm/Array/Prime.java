// 5. 소수(에라토스테네스 체)
import java.util.*;
  
public class Main {
  public int solution(int n) {
    Set<Integer> list = new HashSet<>();
    list.add(1); // 1은 무조건 아님
    for(int i = 2; i <= Math.sqrt(n); i++) {
      for(int j = 2; j <= (int)n/i; j++) {
        list.add(i*j);
      }
    }
    return n - list.size();
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
  
    System.out.println(m.solution(n));

    return ;
  }
}