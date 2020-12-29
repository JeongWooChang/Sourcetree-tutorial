package sw; //욕심쟁이 판다

import java.util.*;

public class Programmers {

public static int ans = 1;
public static int cnt = 1;
public static int n;
public static int num;
public static int[][] arr;
public static boolean[] visited;
public static int[][] dp;
public static ArrayList<Integer> score = new ArrayList<>();
public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		n = s.nextInt();
		arr = new int[n][n];
		dp = new int[n][n];
		
		
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		for(int a = 0 ; a < n ; a++) {
			for(int b = 0 ;b < n ; b++) {
				ans = Math.max(ans, dfs(a,b));
			}
		}
		
		System.out.println(ans);

	}

public static int dfs(int x, int y) {
	if(dp[x][y] != 0) return dp[x][y];
	dp[x][y] = 1;

	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	for(int i = 0 ; i < 4 ; i++) {
		int a = x + dx[i];
		int b = y + dy[i];
		if(a >= 0 && a < n && b >= 0 && b < n) {
			if(arr[x][y] < arr[a][b]) {
				dp[x][y] = Math.max(dp[x][y], dfs(a,b)+1);
				dfs(a,b);
			}
		}
	}
	return dp[x][y];
}

}
