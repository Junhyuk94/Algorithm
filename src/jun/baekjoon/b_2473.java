package jun.baekjoon;

import java.io.*;
import java.util.*;

/*
 * backjoon 2473
 * ¼¼¿ë¾×
 * https://www.acmicpc.net/problem/2473
 * 
 */
public class b_2473 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		
		int min = 999999;
		
		int[] answer = new int[3];
		
		for(int i=0; i<size-2; i++) {
			for(int j=i+1; j<size-1; j++) {
				for(int k=j+1; k<size; k++) {
					
					int sum = arr[i] + arr[j] + arr[k];
					
					if(Math.abs(sum) < min) {
						answer[0] = arr[i];
						answer[1] = arr[j];		
						answer[2] = arr[k];
					}
				}
			}
		}
		
		Arrays.sort(answer);
		
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}
