package codingPractice;

import java.util.ArrayList;
import java.util.List;

public class MakeCompaneyMail {
	

	public static String solution(String S, String C) {
		// John Doe <john.doe@example.com> 예시
		
		String result = ""; // 결과
		List<String> mailList = new ArrayList<String>(); // 중복 검사용 메일목록
		
		String[] people = S.split(", "); // 이름문자 쉼표 기준으로 리스트화
		String mail = ""; // 메일
		String mailByName = ""; // 이름 - 메일
		
		String[] names; // 첫번째 이름과 마지막 이름을 분리하기 위해 만든 이름 문자열
		String firstName = ""; // 첫번째 이름
		String lastName = ""; // 마지막 이름
		
		int duplicateCnt = 1; // 중복 카운트
				
		for(int i=0; i<people.length; i++) {
			
			names = people[i].split(" ");
			firstName = names[0].toLowerCase().replaceAll("-", "");
			lastName = names[names.length - 1].toLowerCase().replaceAll("-", "");
			mail = firstName + "." + lastName + "@" + C + ".com";
			
			// 중복 검사
			while (mailList.contains(mail)) {
				duplicateCnt++;
				mail = firstName + "." + lastName + duplicateCnt + "@" + C + ".com";
			}
			mailList.add(mail);
			
			// 이름과 메일 최종 완성
			mailByName = people[i] + " <" + mail + ">";
			
			if (i==0) {
				result += mailByName;				
			} else {
				result += ", " + mailByName;
			}
			
			duplicateCnt = 1; // 중복카운트 초기화
		}
		return result;
	}

	public static void main(String[] args) {
		
		String S = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, John Doe, Peter Brian Parker";
		String C = "example";
		
		String result = solution(S, C);
		
		
		System.out.println(result);
		
		
	}

}
