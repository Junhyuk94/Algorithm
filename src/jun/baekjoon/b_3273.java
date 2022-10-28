package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * backjoon 3273
 * 두 수의 합
 * https://www.acmicpc.net/problem/3273
 * 
 * arr[i] + arr[i+1]로 풀면 시간초과되어
 * 투포인터로 풀어야 한다.
 */
public class b_3273 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int target = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			
			if(arr[start] + arr[end] == target) {
				 count++;
			}
			
			if(arr[start] + arr[end] <= target) {
				start++;
			}
			else {
				end--;
			}
			
		}
		
		System.out.println(count);
	}
}
