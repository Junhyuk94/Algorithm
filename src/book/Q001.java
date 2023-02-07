package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int sum = 0;
		
		for(int i=0; i<count; i++) {
			sum += s.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}
}
