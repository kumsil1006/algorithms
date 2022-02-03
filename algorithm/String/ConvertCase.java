// 2. 대소문자 변환

import java.util.*;
  
public class Main {
  public String solution(String str) {
    String answer = "";

    for(char c : str.toCharArray()) {
      // 대문자인 경우
      if(Character.isUpperCase(c)) {
        answer += Character.toLowerCase(c);
      } else {
        // 소문자인 경우
        answer += Character.toUpperCase(c);
      }
    }    
    return answer;
  }
  public static void main(String[] args){
    Main T = new Main();

    Scanner in=new Scanner(System.in);
    String str = in.nextLine();

    System.out.println(T.solution(str));

    return ;
  }
}