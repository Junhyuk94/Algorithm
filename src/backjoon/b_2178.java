package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * backjoon 2178
 * �̷� Ž��
 * https://www.acmicpc.net/problem/2178
 */

public class b_2178 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		// reader ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n x m ũ���� �迭�� �Է¹���.
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// n x m ũ���� 2���� �迭 map ����
		int[][] map = new int[n][m];
		
		// n x m ũ���� visited 2���� �迭 ����
		int[][] visited = new int[n][m];
		
		// �̷� �� ����
		for(int i=0; i<n; i++) {
			
			String str = br.readLine(); 
			
			for(int j=0; j<m; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(map, visited); 
		
		System.out.println(visited[n-1][m-1]);
	}
	
	// bfs Ž�� 
	static private void bfs(int[][] map, int[][] visited) {
		
		// ť ����
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0,0});
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			// poll
			int[] current = queue.poll();
			
			// ���� ��ǥ ����
			int currentX = current[0];
			int currentY = current[1];
			
			// ���� ��ǥ���� �����¿� �̵�
			for(int i=0; i<4; i++) {
				
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				
				if(nextX >=0 && nextX < map.length && nextY >=0 && nextY < map[0].length &&
						map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
					
					// queue add
					queue.add(new int[] {nextX, nextY});
					
					// visited ī��Ʈ ����
					visited[nextX][nextY] = visited[currentX][currentY] + 1;
				}
			}
		}
	}
}
