package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		int point[] = new int[count];
		long max = 0;
		double sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count; i++) {
			point[i] = Integer.parseInt(st.nextToken());
			if(point[i] > max) {
				max = point[i];
			}
		}

		for(int i=0; i<count; i++) {
			sum += (double)point[i] * 100 / max;
		}
		
		System.out.println((double)sum / count);
		
	}
}
