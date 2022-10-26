package jun.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 프로그래머스
 * 카카오프렌즈 컬러링북
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 */
public class kakaoColoringBook {
	
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,1,0,-1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		int m = 6;
		int n = 4;
		
		int[][] picture = {
				{1, 1, 1, 0},
				{1, 2, 2, 0},
				{1, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 3},
				{0, 0, 0, 3}
		};
		
		visited = new boolean[m][n];
		int maxSizeOfOneArea = 0;
		int numberOfArea = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(picture[i][j] != 0 && visited[i][j] == false) {
					
					maxSizeOfOneArea = bfs(picture, i, j);
					
					numberOfArea++;
				}
			}
		}
	}
	
	static private int bfs(int[][] picture, int startX, int startY) {
		
		int size = 1;
		int index = picture[startX][startY];
		
		Queue<int[]> queue = new LinkedList<>();
		
		visited[startX][startY] = true;
		
		queue.offer(new int[] {startX, startY});
		
		while(!queue.isEmpty()) {
			
			int[] CurrentPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				
				int nextPosX = CurrentPos[0] + nx[i];
				int nextPosY = CurrentPos[1] + ny[i];
				
				if(nextPosX >= 0 && nextPosX < picture.length && nextPosY >= 0 && nextPosY < picture[0].length &&
						picture[nextPosX][nextPosY] == index && visited[nextPosX][nextPosY] == false) {
					queue.offer(new int[] {nextPosX, nextPosY});
					visited[nextPosX][nextPosY] = true;
					size++;
				}
				
			}
			
		}
		
		return size;
		
	}
	
}