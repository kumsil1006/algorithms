// 4. 모든 아나그램 찾기
import java.util.*;
  
public class Main {
  public int solution(String str2, String str1) {
    int k = str1.length(); // 부분문자열 길이
    int lt = 0, rt = k, cnt = 0;
    char[] arr = str2.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    
    for(char c : str1.toCharArray()) {
      if(map.containsKey(c)) map.put(c, map.get(c)+1);
      else map.put(c, 1);
    }

    for(int i = 0; i < rt; i++) {
      if(map2.containsKey(arr[i])) map2.put(arr[i], map2.get(arr[i])+1);
      else map2.put(arr[i], 1);
    }
    
    while(rt < arr.length-1) {
      if(check(map, map2)) cnt++;
      if(map2.get(arr[lt]) == 1) {
        map2.remove(arr[lt]);
      }
      else map2.put(arr[lt], map2.get(arr[lt])-1);
      lt++;
      rt++;
      if(map2.containsKey(arr[rt])) map2.put(arr[rt], map2.get(arr[rt])+1);
      else map2.put(arr[rt], 1);      
    }
    return cnt;
  }
  public boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    Set<Character> arr1 = map1.keySet();
    Set<Character> arr2 = map2.keySet();
    System.out.println(map2);
    if(arr1.size() != arr2.size()) return false;
    for(char c : arr1) {
      if(!map2.containsKey(c)) return false;
      if(map1.get(c) != map2.get(c)) return false;
    }
    return true;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    
    String str1 = in.next();
    String str2 = in.next();
    
    System.out.println(t.solution(str1, str2));
    return ;
  }
}