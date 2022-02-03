// 3. 문장 속 단어
import java.util.*;
  
public class Main {
  public String solution(String str) {
    List<String> list = new ArrayList<>();
    String[] arr = str.split(" ");

    int length = Integer.MIN_VALUE;
    String answer = "";
    
    for(String a : arr) {
      if(a.length() > length) {
        answer = a;
        length = a.length();
      }
    }
    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(m.solution(str));
    return ;
  }
}