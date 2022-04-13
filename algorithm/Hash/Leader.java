// 1. 학급회장
import java.util.*;
  
public class Main {
  public char solution(int n, String vote) {
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    char result = ' ';
    
    for(char c : vote.toCharArray()) {
      if(map.containsKey(c)) map.put(c, map.get(c)+1);
      else map.put(c, 1);
    }

    for(char c : map.keySet()) {
      if(map.get(c) > max) {
        max = map.get(c);
        result = c;
      }
    }
    return result;
  }
  
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    String vote = in.next();
    
    System.out.println(t.solution(n, vote));
    return ;
  }
}