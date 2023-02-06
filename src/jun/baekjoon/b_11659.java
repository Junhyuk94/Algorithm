package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 11659
 * 구간 합 구하기 4
 * 일반적으로 배열에서 더하면 시간초과 되므로, 합배열 사용.
 * 
 * 구간 합 공식
 * 	- i~j구간의 합 : S[j] - S[i-1]
 * 
 * https://www.acmicpc.net/problem/11659
 */
public class b_11659 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		// 합배열
		int arrSum[] = new int[size+1];
		arrSum[0] = 0;
		
		for(int i=1; i<size+1; i++) {
			if(i==1) {
				st = new StringTokenizer(br.readLine());
				arrSum[i] = Integer.parseInt(st.nextToken());
				continue;
			}
			arrSum[i] = arrSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int start, end = 0;
		
		for(int i=0; i<count; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			System.out.println(arrSum[end] - arrSum[start-1]); 	
		}
	}
}
