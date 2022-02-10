// 4. 피보나치 수열
import java.util.*;
  
public class Main {
  public int[] solution(int n) {
    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 1;
    
    for(int i = 2; i < n; i++) {
      arr[i] = arr[i-2] + arr[i-1];
    }
    
    return arr;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int idx = 0;

    for(int i : m.solution(n)) {
      if(idx > 0) System.out.print(" ");
      System.out.print(i);
      idx += 1;
    }

    return ;
  }
}