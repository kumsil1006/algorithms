// 8. 등수구하기
import java.util.*;

public class Main {
  public int[] solution(int n, int[] arr) {
    int[] rank = new int[n];
    List<Integer> list = new ArrayList<>();

    for(int i : arr) {
      list.add(i);
    }

    Collections.sort(list);

    for(int i = 0; i < list.size(); i++) {
      for(int j = 0; j < arr.length; j++) {
        if(list.get(i) == arr[j]) {
          rank[j] = n-i;
        }
      }
    }
    
    return rank;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    
    int[] result = m.solution(n, arr);
    int idx = 0;
    
    for(int i : result) {
      if(idx++ > 0) System.out.print(" ");
      System.out.print(i);
    }

    return ;
  }
}