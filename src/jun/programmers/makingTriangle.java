package jun.programmers;

/*
 * ���α׷��ӽ�
 * �ﰢ���� �ϼ����� (2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class makingTriangle {

	public static void main(String[] args) {

		int[] sides = { 3, 6 };

		int answer = 0;
		int max, min, start;

		if (sides[0] >= sides[1]) {
			max = sides[0];
			min = sides[1];
		} else {
			max = sides[1];
			min = sides[0];
		}

		// 1. sides�� ���� �� ���� �������
		// max������ �����ؼ� 1�� �ٿ������� üũ
		start = max;

		while (true) {
			if (start + min > max) {
				answer++;
				start--;
				continue;
			}
			break;
		}

		// 2. ������ �� ���� ���� �� ���� ���
		// max+1���� ����gotj 1�� ���ذ��� üũ
		start = max + 1;

		while (true) {
			if (max + min > start) {
				answer++;
				start++;
				continue;
			}
			break;
		}

		//return answer;
	}

}
