// 6. 장난꾸러기
import java.util.*;

public class Main {

  public int[] solution(int n, int[] arr) {
    int[] result = new int[2];
    int[] arr2 = Arrays.copyOf(arr, n);
    int idx = 0;
    Arrays.sort(arr2);

    for(int i = 0; i < n; i++) {
      if(arr[i] != arr2[i]) {
        result[idx++] = i+1;
      }
    }
    
    return result;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    for(int i : t.solution(n, arr)) {
      System.out.print(i + " ");
    }
    // System.out.println(t.solution(n, arr));
    return ;
  }
}