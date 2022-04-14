// 6. 부분집합 구하기(DFS)

class Main {
  static int n;
  static int[] ch; // 해당 숫자를 부분집합으로 사용하는지 여부 체크

  public void DFS(int L) {
    if(L == n+1) {
      // 종착점
      String tmp = "";
      for(int i = 1; i <= n; i++) {
        if(ch[i] == 1) tmp += (i+ " ");
      }
      if(tmp.length() > 0) System.out.println(tmp); 
    } else {
      ch[L] = 1;
      DFS(L+1); // 사용 O
      
      ch[L] = 0;
      DFS(L+1); // 사용 X
    }
  }
  public static void main(String[] args) {
    Main m = new Main();
    n = 3;
    ch = new int[n+1];
    m.DFS(1);
  }
}