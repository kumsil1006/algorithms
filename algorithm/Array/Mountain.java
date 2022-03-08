// 10. 봉우리
import java.util.*;

public class Main {
  public int solution(int n, int[][] arr) {
    int result = 0;
    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < n+1; j++) {
        int t = arr[i][j];
        
        if(arr[i][j-1] < t && arr[i][j+1] < t && arr[i-1][j] < t && arr[i+1][j] < t) {
          result += 1;
        }
      
      }
    }
    return result;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[][] arr = new int[n+2][n+2];
    
    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < n+1; j++) {
         arr[i][j] = in.nextInt(); 
      }
    }
    
    System.out.println(m.solution(n, arr));

    return ;
  }
}