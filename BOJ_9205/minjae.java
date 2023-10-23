package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9205 {
	// ���� ����
	static int[] home;	// ����� �� ��ǥ
	static int[][] mart;	// ������ ��ǥ
	static int[] festival;	// ���� ��ǥ
	static int[] visited;	// �湮ó���� �迭
	static Queue<Integer> q = new LinkedList<>();	// ť

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());	// ������ ����
			
			// �� ��ǥ �Է�
			home = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			// ������ ��ǥ �Է�
			mart = new int[n][2];
			visited = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				mart[i][0] = Integer.parseInt(st.nextToken());
				mart[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// ���� ��ǥ �Է�
			festival = new int[2];
			st = new StringTokenizer(br.readLine());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());
			
			boolean result = bfs(home[0], home[1]);
			
			// ������� true�� happy, false�� sad ���
			if(result) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			// ���� ��� ArrayIndexOutOfBounds ���� �߻�
			
		}// tc for
	}
	
	static boolean bfs(int r, int c) {
		// ���� ��ǥ
		int row = r;
		int col = c;
		
		if(Math.abs(festival[0]-row) + Math.abs(festival[1]-col) <= 1000) {
			// ���� ��ġ�� ���� ��ġ�� 1000m �̳����
			return true;
		}
		else {
			// ���� ��ġ�� ���� ��ġ�� 1000m �Ѱ� ���̳���
			for (int i = 0; i < mart.length; i++) {
				// �������� ã�ư���
				if(visited[i] == 0 && (Math.abs(mart[i][0]-row) + Math.abs(mart[i][1]-col)) <= 1000) {
					// ���� �湮���� �ʾҰ�, ���� ��ġ���� ���̰� 1000 �̳��� �������̶��
					q.add(i);	// �ش� ������ �湮
					visited[i] = 1;
				}
			}
		}
		
		while(q.size() > 0) {
			int idx = q.poll();		// �湮�� ������ �ε���
			if(Math.abs(festival[0]-mart[idx][0]) + Math.abs(festival[1]-mart[idx][1]) <= 1000) {
				// ���� ��ġ�� ���� ��ġ�� 1000m �̳����
				return true;
			}
			else {
				// ���� ��ġ�� ���� ��ġ�� 1000m �Ѱ� ���̳���
				for (int i = 0; i < mart.length; i++) {
					// �������� ã�ư���
					if(visited[i] == 0 && (Math.abs(mart[i][0]-mart[idx][0]) + Math.abs(mart[i][1]-mart[idx][1])) <= 1000) {
						// ���� �湮���� �ʾҰ�, ���� ��ġ���� ���̰� 1000 �̳��� �������̶��
						q.add(i);	// �ش� ������ �湮
						visited[i] = 1;
					}
				}
			}
		}
		return false;
	}

}
