// 2. 보이는 학생
import java.util.*;
  
public class Main {
  public int solution(int n, int[] arr) {
    int answer = 0, max = 0;

    for(int i = 0; i < n; i++) {
      if(arr[i] > max) {
        max = arr[i];
        answer += 1;
      }
    }

    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int input = in.nextInt();
    int[] inArr = new int[input];
    
    for(int i = 0; i < input; i++) {
      inArr[i] = in.nextInt();  
    }
    
    System.out.println(m.solution(input, inArr));

    return ;
  }
}