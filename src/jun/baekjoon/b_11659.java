package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 11659
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class b_11659 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[size]; 
		
		for(int i=0; i<size; i++) {
			if(i==0) {
				st = new StringTokenizer(br.readLine());
			}
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start, end, sum = 0;
		
		for(int i=0; i<count; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			sum = 0;
			
			for(int j=start-1; j<end; j++) {
				sum += arr[j];
			}
			
			System.out.println(sum); 
		}
	}
}
