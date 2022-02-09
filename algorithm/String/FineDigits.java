// 9. 숫자만 추출
import java.util.*;
  
public class Main {
  public int solution(String str) {
    str = str.replaceAll("[^0-9]", "");
    
    return Integer.parseInt(str);
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();

    System.out.println(m.solution(input));
    return ;
  }
}