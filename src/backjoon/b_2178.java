package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * backjoon 2178
 * 미로 탐색
 * https://www.acmicpc.net/problem/2178
 */

public class b_2178 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		// reader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n x m 크기의 배열을 입력받음.
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// n x m 크기의 2차원 배열 map 생성
		int[][] map = new int[n][m];
		
		// n x m 크기의 visited 2차원 배열 생성
		int[][] visited = new int[n][m];
		
		// 미로 값 셋팅
		for(int i=0; i<n; i++) {
			
			String str = br.readLine(); 
			
			for(int j=0; j<m; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(map, visited); 
		
		System.out.println(visited[n-1][m-1]);
	}
	
	// bfs 탐색 
	static private void bfs(int[][] map, int[][] visited) {
		
		// 큐 선언
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0,0});
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			// poll
			int[] current = queue.poll();
			
			// 현재 좌표 설정
			int currentX = current[0];
			int currentY = current[1];
			
			// 현재 좌표에서 상하좌우 이동
			for(int i=0; i<4; i++) {
				
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				
				if(nextX >=0 && nextX < map.length && nextY >=0 && nextY < map[0].length &&
						map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
					
					// queue add
					queue.add(new int[] {nextX, nextY});
					
					// visited 카운트 증가
					visited[nextX][nextY] = visited[currentX][currentY] + 1;
				}
			}
		}
	}
}
