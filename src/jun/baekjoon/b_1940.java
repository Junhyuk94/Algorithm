package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * backjoon 1940
 * 
 * 주몽
 * 
 * https://www.acmicpc.net/problem/1940
 */
public class b_1940 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int [count];
		
		for(int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start_index = 0;
		int end_index = count-1;
		int sum = 0;
		int answer = 0;
		
		while(start_index < end_index) {
			
			sum = arr[start_index] + arr[end_index];
			
			if(sum == target) {
				start_index++;
				end_index--;
				answer++;
			}else if(sum < target) {
				start_index++;
			}else if(sum > target) {
				end_index--;
			}
		}
		
		System.out.println(answer);
	}
}
