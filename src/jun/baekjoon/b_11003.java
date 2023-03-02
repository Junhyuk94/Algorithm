package jun.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * backjoon 11003
 * 최솟값 찾기
 * https://www.acmicpc.net/problem/11003
 * 
 */
public class b_11003 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n개의 
		int n = Integer.parseInt(st.nextToken());
		// 슬라이딩 윈도우 크기
		int windowSize = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node> deque = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			
			int now = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			
			deque.addLast(new Node(now, i));
			
			if(deque.getFirst().index <= i-windowSize) {
				deque.removeFirst();
			}
			
			bw.write(deque.getFirst().value + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	private static class Node{
		private int value;
		private int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
