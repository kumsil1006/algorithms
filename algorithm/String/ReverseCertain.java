// 5. 특정 문자 뒤집기

import java.util.*;
  
public class Main {
  public String solution(String str) {
    char[] answer = str.toCharArray();
    int lt = 0, rt = str.length() - 1;

    while(lt < rt) {
      boolean result1 = String.valueOf(str.charAt(lt)).matches("[a-zA-Z]");
      boolean result2 = String.valueOf(str.charAt(rt)).matches("[a-zA-Z]");
      if(result1 && result2) {
        char temp = answer[lt];
        answer[lt] = answer[rt];
        answer[rt] = temp;
        lt++;
        rt--;
      } else if(result1) {
        rt--;
      } else {
        lt++;
      }
    }
    
    return String.valueOf(answer);
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();

    System.out.println(m.solution(str));
    
    return ;
  }
}