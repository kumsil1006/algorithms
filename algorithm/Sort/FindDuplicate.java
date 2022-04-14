// 5. 중복 확인
import java.util.*;
  
public class Main {
  public String solution(int n, int[] arr) {
    
    Arrays.sort(arr);
    for(int i = 0; i < arr.length-1; i++) {
      if(arr[i] == arr[i+1]) return "D";
    }
    return "U";
  }
  
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    System.out.println(t.solution(n, arr));
    return ;
  }
}