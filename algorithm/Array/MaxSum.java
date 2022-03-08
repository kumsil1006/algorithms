// 9. 격자판 최대합
import java.util.*;

public class Main {
  public int solution(int n, int[][] arr) {
    int max = 0;
    int sum1 = 0, sum2 = 0;
    
    for(int i = 0; i < n; i++) {
      sum1 = 0;
      sum2 = 0;
      for(int j = 0; j < n; j++) {
        sum1 += arr[i][j];
        sum2 += arr[j][i];
      }
      if(sum1 > max) max = sum1;
      if(sum2 > max) max = sum2;
    }
    sum1 = 0;
    sum2 = 0;
    for(int i = 0; i < n; i++) {
      sum1 += arr[i][n-i-1];
      sum2 += arr[i][i];
    }

    if(sum1 > max) max = sum1;
    if(sum2 > max) max = sum2;
    return max;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[][] arr = new int[n][n];
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
         arr[i][j] = in.nextInt(); 
      }
    }
    
    System.out.println(m.solution(n, arr));

    return ;
  }
}