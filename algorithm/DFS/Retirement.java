import java.util.*;

class Main {
  static int maxIdx, max, sum, n;
  static int[] ch, tArr, pArr;
  
  public void DFS(int i, int k) {
    int ni = i + tArr[i];
    if(ni > n) {
      return ;
    }
    System.out.println((ni+tArr[ni]) + " " + n);
    if(ch[ni] != 1 && ni+tArr[ni] <= n+1) {
      ch[ni] = 1;
      sum += pArr[ni];
      System.out.println(i + " " + ni + " " + tArr[i] + " " + sum);
      DFS(ni);
    }
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    maxIdx = -1;
    max = Integer.MIN_VALUE;
    
    n = kb.nextInt();
    tArr = new int[n+1];
    pArr = new int[n+1];
    
    for(int i = 1; i <= n; i++) {
      tArr[i] = kb.nextInt();
      pArr[i] = kb.nextInt();
    }

    for(int i = 1; i < n; i++) {
      sum = 0;
      if(i + tArr[i] > n) {
        continue;
      }
      System.out.println("-----------------------");
      sum = pArr[i];
      ch = new int[n+1];
      T.DFS(i, i-1);
      
      if(max < sum) {
        maxIdx = i;
        max = sum;
      }
    }
    System.out.println(max);
    
  }
}