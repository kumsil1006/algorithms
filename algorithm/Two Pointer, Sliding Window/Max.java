// 3. 최대 매출
import java.util.*;

public class Main {
  public int solution(int n, int k, int[] arr) {
    int p = 0, max = Integer.MIN_VALUE, s = 0;

    for(int i = 0; i < k; i++) {
      s += arr[i];
    }

    max = s;
    
    for(int i = k; i < n; i++) {
      s = s - arr[p++] + arr[i];
      if(s > max) max = s;
    }
    
    return max;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    int result = m.solution(n, k, arr);
    System.out.println(result);
    return ;
  }
}