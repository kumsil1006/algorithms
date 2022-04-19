// 5. K번째 큰 수
import java.util.*;

public class Main {

  public int solution(int n, int k, Integer[] arr) {
    Set<Integer> set = new TreeSet<>();
    if(n < k) return -1;
    int answer = Integer.MIN_VALUE;
    int cnt = 0, sum = 0;
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        for(int r = 0; r < n; r++) {
          if(i != j && i != r && j != r) {
            set.add(arr[i] + arr[j] + arr[r]);
          }
        }
      }
    }

    Integer[] array = set.toArray(new Integer[0]);
    //System.out.println(set);
    return array.length < k ? -1 : 
array[array.length-k];
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    int k = in.nextInt();
    Integer[] arr = new Integer[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(t.solution(n, k, arr));
    return ;
  }
}