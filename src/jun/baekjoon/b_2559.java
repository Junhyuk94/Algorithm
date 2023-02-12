package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 2559
 * 수열
 * https://www.acmicpc.net/problem/2559
 * 
 */

public class b_2559 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[size];
		int[] sumArr = new int[size];
		
		 st = new StringTokenizer(br.readLine());
		// [3, -2, -4, -9, 0, 3, 7, 13, 8, -3]
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				sumArr[i] = arr[i];
			}else {
				sumArr[i] = arr[i] + sumArr[i-1];
			}
		}
		
		System.out.println(arr);
	}

}
