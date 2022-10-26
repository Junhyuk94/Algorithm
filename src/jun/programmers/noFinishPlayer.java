package jun.programmers;
import java.util.HashMap;

/*
 * 프로그래머스
 * 완주하지못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

public class noFinishPlayer {

	public static void main(String[] args) {

		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		String answer = "";
		
		// HashMap 선언
		HashMap<String, Integer> hm = new HashMap<>();

		// 참가선수 HashMap에 저장
		// Value는 1로 셋팅하고 동명이인이 있으면 +1씩 증가
		for (String s : participant) {

			if (hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
			}
		}

		// 완주한 선수를 HashMap에서 찾아 Value를 -1함.
		for (String s : completion) {
			hm.put(s, hm.get(s) - 1);
		}
		
		// Value가 1로 남아있으면 완주하지 못한 선수가 됨.
		for (String s : hm.keySet()) {
			if (hm.get(s) == 1) {
				answer = s;
			}
		}
		
		System.out.println(answer);
	}
}
