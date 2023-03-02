package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * backjoon 11047
 * ����
 * https://www.acmicpc.net/problem/11047
 */
public class b_11047 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ��������
		int n = Integer.parseInt(st.nextToken()); 
		// ��ġ�� ��
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		// �ʿ��� ������ ���� 
		int count = 0;
		
		for(int i=n-1; i>=0; i--) {
			
			if(k==0) {
				break;
			}
			
			// ���� ������ �� ũ�� skip
			if(coin[i] > k) {
				continue;
			}
			
			// �������� ������ ���� ������ ī����
			count = count + (k / coin[i]);
			
			// ������������ �ٽ� ����
			k = k % coin[i];
			
		}
		
		System.out.println(count);
	}

}
