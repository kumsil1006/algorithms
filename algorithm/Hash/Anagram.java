// 2. 아나그램
import java.util.*;
  
public class Main {
  public String solution(String str1, String str2) {
    Map<Character, Integer> map = new HashMap<>();
    
    for(char c : str1.toCharArray()) {
      if(map.containsKey(c)) map.put(c, map.get(c)+1);
      else map.put(c, 1);
    }

    for(char c : str2.toCharArray()) {
      if(!map.containsKey(c)) return "NO";
      map.put(c, map.get(c)-1);
    }

    for(char c : map.keySet()) {
      if(map.get(c) != 0) return "NO";
    }
    return "YES";
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