package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 11047
 * 동전
 * https://www.acmicpc.net/problem/11047
 */
public class b_11047 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전갯수
		int n = Integer.parseInt(st.nextToken()); 
		// 가치의 합
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		// 필요한 동전의 개수
		int count = 0;
		
		for(int i=n-1; i>=0; i--) {
			
			if(k==0) {
				break;
			}
			
			// 동전 단위가 더 크면 skip
			if(coin[i] > k) {
				continue;
			}
			
			// 동전으로 나누어 몫을 갯수로 카운팅
			count = count + (k / coin[i]);
			
			// 나머지값으로 다시 셋팅
			k = k % coin[i];
			
		}
		
		System.out.println(count);
	}

}
