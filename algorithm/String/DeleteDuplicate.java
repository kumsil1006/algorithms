// 6. 중복 문자 제거
import java.util.*;
  
public class Main {
  public String solution(String str) {
      List<Character> list = new ArrayList<>();

      for(char c : str.toCharArray()) {
        if(!list.contains(c)) list.add(c);
      }
      char[] answer = new char[list.size()];

      for(int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
      }
      
      return String.valueOf(answer);
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();

    System.out.println(m.solution(input));
    return ;
  }
}