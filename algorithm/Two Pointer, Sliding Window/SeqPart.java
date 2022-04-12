// 4. 연속 부분수열
import java.util.*;

public class Main {
  public int solution(int n, int k, int[] arr) {
    // todo
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