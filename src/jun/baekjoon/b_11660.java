package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 11660
 * ���� �� ���ϱ� 5
 * 2���� �չ迭 ���.
 * 
 * 2���� �չ迭 ���� ����
 * 	- �����迭 A, �չ迭 S�϶�, S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j] 
 * 
 * 2���� �չ迭 ���� �� ���ϱ� ����
 *  - �����迭 A, �չ迭 S�϶�, (x1 ,y1) ~ (x2, y2) ����
 *    S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]
 * 
 * https://www.acmicpc.net/problem/11660
 */
public class b_11660 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// �����迭 ���� 
		int arrA[][] = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<n+1; j++) {
				arrA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �չ迭 ����
		int arrSum[][] = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				arrSum[i][j] = arrSum[i-1][j] + arrSum[i][j-1] - arrSum[i-1][j-1] + arrA[i][j]; 
			}
		}
		
		// ���
		int x1, y1, x2, y2, result = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			result = arrSum[x2][y2] - arrSum[x1-1][y2] - arrSum[x2][y1-1] + arrSum[x1-1][y1-1];  
					
			System.out.println(result);
		}
	}
}
