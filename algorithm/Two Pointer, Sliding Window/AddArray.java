// 1. 배열 합치기
import java.util.*;

public class Main {
  public int[] solution(int n, int[] arr1, int m, int[] arr2) {
    int p1 = 0, p2 = 0;
    List<Integer> list = new ArrayList<>();
    while(list.size() < n+m) {
      if(p1 < n && p2 >= m) {
        list.add(arr1[p1++]);
      } else if(p1 < n && arr1[p1] < arr2[p2]) {
        list.add(arr1[p1++]);
      } else if(p2 < m) {
        list.add(arr2[p2++]);
      }
    }
    
    return list.stream().mapToInt(i->i).toArray();
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr1 = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr1[i] = in.nextInt();
    }

    int n2 = in.nextInt();
    int[] arr2 = new int[n2];
    
    for(int i = 0; i < n2; i++) {
      arr2[i] = in.nextInt();
    }    
    int[] result = m.solution(n, arr1, n2, arr2);

    for(int i : result) {
      System.out.print(i + " ");
    }
    return ;
  }
}