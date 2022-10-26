package jun.programmers;
import java.util.HashMap;

/*
 * ���α׷��ӽ�
 * ������������ ����
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

public class noFinishPlayer {

	public static void main(String[] args) {

		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		String answer = "";
		
		// HashMap ����
		HashMap<String, Integer> hm = new HashMap<>();

		// �������� HashMap�� ����
		// Value�� 1�� �����ϰ� ���������� ������ +1�� ����
		for (String s : participant) {

			if (hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
			}
		}

		// ������ ������ HashMap���� ã�� Value�� -1��.
		for (String s : completion) {
			hm.put(s, hm.get(s) - 1);
		}
		
		// Value�� 1�� ���������� �������� ���� ������ ��.
		for (String s : hm.keySet()) {
			if (hm.get(s) == 1) {
				answer = s;
			}
		}
		
		System.out.println(answer);
	}
}
