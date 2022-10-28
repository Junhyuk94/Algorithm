package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * backjoon 2309
 * 일곱난장이
 * https://www.acmicpc.net/problem/2309
 */
public class b_2309 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int[] people = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			people[i] = Integer.parseInt(br.readLine());
			sum += people[i];
		}
		
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - people[i] - people[j] == 100) {
					people[i] = 0;
					people[j] = 0;
					
					Arrays.sort(people);
					
					for(int k=2; k<9; k++) {
						System.out.println(people[k]);
					}
					
					return;
				}
			}
		}
	}
}
