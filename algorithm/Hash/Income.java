// 3. 매출액의 종류
import java.util.*;
  
public class Main {
  public int[] solution(int n, int k, int[] arr) {
    int lt = 0, rt = k;
    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[n-k+1];
    for(int i = 0; i < rt; i++) {
      if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
      else map.put(arr[i], 1);
    }
    result[lt] = map.keySet().size();
    
    while(rt < n) {
      // 1. 우측 추가
      if(map.containsKey(arr[rt])) map.put(arr[rt], map.get(arr[rt])+1);
      else map.put(arr[rt], 1);      
      // 2. 좌측 삭제
      if(map.get(arr[lt]) == 1) map.remove(arr[lt]);
      else map.put(arr[lt], map.get(arr[lt])-1);
      rt++;
      lt++;
      result[lt] = map.keySet().size();
    }
    return result;
  }
  
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    for(int i : t.solution(n, k, arr)) {
        System.out.print(i + " ");
    }
    return ;
  }
}