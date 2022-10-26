package jun.backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * backjoon 1260
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class b_1260 {
	
	static int[][] array;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		
		// 정점의 개수 N, 간선의개수 M, 시작할 정점번호 V
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수
		int n = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int m = Integer.parseInt(st.nextToken());
		// 시작할 정점번호
		int v = Integer.parseInt(st.nextToken());
		
		array = new int[n+1][n+1];
		
		// 배열 간선 추가
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
