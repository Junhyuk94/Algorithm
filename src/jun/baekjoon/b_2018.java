package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 2018
 * 
 * 수들의 합 5
 * 
 * https://www.acmicpc.net/problem/2018
 */
public class b_2018 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			arr[i] = i;
		}
		
		int start = 1, end = 1;
		int sum = 1, count = 1;
		
		while(end != n) {
			
			if(sum < n) {
				sum += ++end;
			}
			else if(sum > n) {
				sum -= start++;
			}
			else if(sum == n) {
				sum += ++end;
				count++;
			}
		}
		System.out.println(count);
	}
}
