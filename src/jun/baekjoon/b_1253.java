package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * backjoon 1253
 * 
 * 좋다
 * 
 * https://www.acmicpc.net/problem/1253
 */
public class b_1253 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[count];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start_index, end_index, target, answer = 0, sum = 0;
		
		for(int i=0; i<count; i++) {
			
			start_index = 0;
			end_index = count-1;
			
			target = arr[i];
			
			while(start_index < end_index) {
				sum = arr[start_index] + arr[end_index];
				
				if(sum == target) {
					if(start_index != i && end_index != i) {
						answer++;
						break;
					}
					else if(start_index == i) {
						start_index++;
					}
					else if(end_index == i) {
						end_index--;
					}
				}
				else if(sum < target) {
					start_index++;
				}
				else if(sum > target) {
					end_index--;
				}
			}
		}
		
		System.out.println(answer);
	}
}
