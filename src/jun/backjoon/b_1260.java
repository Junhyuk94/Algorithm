package jun.backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * backjoon 1260
 * DFS�� BFS
 * https://www.acmicpc.net/problem/1260
 */
public class b_1260 {
	
	static int[][] array;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		
		// ������ ���� N, �����ǰ��� M, ������ ������ȣ V
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ������ ����
		int n = Integer.parseInt(st.nextToken());
		// ������ ����
		int m = Integer.parseInt(st.nextToken());
		// ������ ������ȣ
		int v = Integer.parseInt(st.nextToken());
		
		array = new int[n+1][n+1];
		
		// �迭 ���� �߰�
		for(int i=0; i<m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
					
			array[a][b] = 1;
			array[b][a] = 1;
		}

		visited = new boolean[n+1];
		dfs(v);
		
		System.out.println();
		
		visited = new boolean[n+1];
		bfs(v);
	}
	
	// dfs
	private static void dfs(int v) {
		
		visited[v] = true;
		
		System.out.print(v + " ");
		
		if(v==array.length) {
			return;
		}
		else {
			for(int i=0; i<array.length; i++) {
				if(array[v][i] == 1 && visited[i] == false) {
					dfs(i);
				}
			}
		}
	}
	
	// bfs
	private static void bfs(int v) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			
			int poll = queue.poll();
			System.out.print(poll + " ");
			
			for(int i=0; i<array.length; i++) {
				if(array[poll][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
