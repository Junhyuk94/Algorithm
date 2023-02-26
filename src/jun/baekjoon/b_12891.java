package jun.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * backjoon 12891
 * DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 * 
 */
public class b_12891 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// DNA 문자열 길이
		int dnaLength = Integer.parseInt(st.nextToken());
		
		// 비밀번호 길이
		int pwLength = Integer.parseInt(st.nextToken());
		
		// DNA 문자열
		String Dna = br.readLine();
		
		String[] DnaArr = new String[Dna.length()];
		
		for(int i=0; i<Dna.length(); i++) {
			DnaArr[i] = Dna.charAt(i) + "";
		}
		
		// 검증배열
		int[] vfrcArr = new int[4];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<vfrcArr.length; i++) {
			vfrcArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 슬라이딩윈도우 용 임시 배열 및 비밀번호 길이만큼 입력
		String[] tmpArr = new String[pwLength];
		
		int[] count = new int[4];
		
		for(int i=0; i<pwLength; i++) {
			
			tmpArr[i] = DnaArr[i];
			
			if("A".equals(tmpArr[i])) {
				count[0]++;
			}
			else if("C".equals(tmpArr[i])) {
				count[1]++;
			}
			else if("G".equals(tmpArr[i])) {
				count[2]++;
			}
			else if("T".equals(tmpArr[i])) {
				count[3]++;
			}
		}
		
		int start = 0;
		int end = pwLength;
		int answer = 0;
		
		while(end <= dnaLength) {
			if(count[0] >= vfrcArr[0]
					&& count[1] >= vfrcArr[1]
					&& count[2] >= vfrcArr[2]
					&& count[3] >= vfrcArr[3]) {
				answer++;
			}
			
			// 슬라이딩윈도우 첫번째 값 제거
			if("A".equals(DnaArr[start])) {
				count[0]--;
			}
			else if("C".equals(DnaArr[start])) {
				count[1]--;
			}
			else if("G".equals(DnaArr[start])) {
				count[2]--;
			}
			else if("T".equals(DnaArr[start])) {
				count[3]--;
			}
			
			start++;
			end++;
			
			if(end <= dnaLength){
				if("A".equals(DnaArr[end-1])) {
					count[0]++;
				}
				else if("C".equals(DnaArr[end-1])) {
					count[1]++;
				}
				else if("G".equals(DnaArr[end-1])) {
					count[2]++;
				}
				else if("T".equals(DnaArr[end-1])) {
					count[3]++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
