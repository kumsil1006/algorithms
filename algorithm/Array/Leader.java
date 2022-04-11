// 11. 임시반장 정하기
import java.util.*;

public class Main {
  public int solution(int n, int[][] arr) {
    int answer = 0, max = -1;
    int[] c = new int[n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        for(int k = 0; k < 5; k++) {
          if(i != j && arr[i][k] == arr[j][k]) {
            c[i] += 1;
            break;
          }
        }
      }
    }

    for(int i = 0; i < n; i++) {
      if(c[i] > max) {
        max = c[i];
        answer = i;
      }
    }

    return answer + 1;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[][] arr = new int[n][5];
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 5; j++) {
         arr[i][j] = in.nextInt(); 
      }
    }
    
    System.out.println(m.solution(n, arr));

    return ;
  }
}