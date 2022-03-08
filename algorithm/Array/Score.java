// 7. 점수 계산
import java.util.*;

public class Main {
  public int solution(int n, int[] arr) {
    int sum = 0, cnt = 0;
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == 0) cnt = 0;
      else sum += ++cnt;
    }
    
    return sum;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(m.solution(n, arr));

    return ;
  }
}