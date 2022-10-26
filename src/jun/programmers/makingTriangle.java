package jun.programmers;

/*
 * 프로그래머스
 * 삼각형의 완성조건 (2)
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

		// 1. sides에 가장 긴 변이 있을경우
		// max값부터 시작해서 1씩 줄여나가며 체크
		start = max;

		while (true) {
			if (start + min > max) {
				answer++;
				start--;
				continue;
			}
			break;
		}

		// 2. 나머지 한 변이 가장 긴 변인 경우
		// max+1부터 시작gotj 1씩 더해가며 체크
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
