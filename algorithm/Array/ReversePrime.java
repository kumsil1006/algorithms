// 6. 뒤집은 수

import java.util.*;

public class Main {
  public int[] solution(int n, int[] arr) {
    List<Integer> answer = new ArrayList<>();
    
    for(int i = 0; i < n; i++) {
      StringBuffer r = new StringBuffer(Integer.toString(arr[i]));
      int target = Integer.parseInt(r.reverse().toString());
      if(isPrime(target)) {
        answer.add(target);
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
  public boolean isPrime(int n) {
    if(n <= 1) return false;
    for(int i = 2; i <= (int)n/2; i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    int[] result = m.solution(n, arr);
    for(int i = 0; i < result.length; i++) {
      if(i > 0) System.out.print(" ");
      System.out.print(result[i]);
    }
    return ;
  }
}