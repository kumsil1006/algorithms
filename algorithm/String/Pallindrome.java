// 7. 회문 문자열
import java.util.*;
  
public class Main {
  public String solution(String str) {
    String revStr = new StringBuilder(str.toUpperCase()).reverse().toString();
    str = str.toUpperCase();

    return revStr.equals(str) ? "YES" : "NO";
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();

    System.out.println(m.solution(input));
    return ;
  }
}