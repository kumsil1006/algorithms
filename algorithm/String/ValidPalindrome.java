// 8. 유효한 팰린드롬
import java.util.*;
  
public class Main {
  public String solution(String str) {
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    String reverse = new StringBuilder(str).reverse().toString();
    
    return str.equals(reverse) ? "YES" : "NO";
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(m.solution(str));
    return ;
  }
}