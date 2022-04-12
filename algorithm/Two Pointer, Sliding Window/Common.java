// 2. 공통원소 구하기
import java.util.*;

public class Main {
  public List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
    int p1 = 0, p2 = 0;
    List<Integer> list = new ArrayList<>();
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    while(p1 < n && p2 < m) {
      if(arr1[p1] < arr2[p2]) p1++;
      else if(arr1[p1] > arr2[p2]) p2++;
      else {
        list.add(arr1[p1++]);
        p2++;       
      }
    }
    
    return list;
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
    List<Integer> result = m.solution(n, arr1, n2, arr2);

    for(int i : result) {
      System.out.print(i + " ");
    }
    return ;
  }
}