package codingPractice;

/**
	잠겨 있는 다이얼 자물쇠가 있습니다. 이 자물쇠를 풀기 위해서는 비밀번호를 눈금선에 맞추어야 합니다. 현재 눈금선에 맞추어져 있는 수의 각 자리를 정방향, 또는 역방향으로 회전하여 비밀번호의 수와 맞출 수 있습니다. 이 때, 자물쇠를 풀기 위해 회전시키는 횟수의 최솟값을 구하려고 합니다. 예를 들어, 현재 눈금선의 숫자는 "82195" 이고, 비밀번호가 "64723" 이라면 다음과 같은 연산을 거쳐 자물쇠를 풀 수 있습니다.
	
	1번째 비밀번호 : 8→ 7→ 6 (역방향 2회)
	2번째 비밀번호 : 2→ 3→ 4 (정방향 2회)
	3번째 비밀번호 : 1→ 0→ 9→ 8→ 7 (역방향 4회)
	4번째 비밀번호 : 9→ 0→ 1→ 2 (정방향 3회)
	5번째 비밀번호 : 5→ 4→ 3 (역방향 2회)
	총 횟수 : 13회
	물론 이 방법 이외에도 다른 방법으로 회전시켜 자물쇠를 풀 수 있지만, 해당 방법보다 더 작은 횟수로 자물쇠를 푸는 방법은 없습니다. 따라서 최솟값은 13이 됩니다. 현재 눈금선에 있는 숫자 P와, 비밀번호 S가 매개변수로 주어질 때, 자물쇠를 풀기 위한 최소 회전 횟수를 return 하는 solution 함수를 완성해 주세요.
 */
public class SecretNumber {
	
	
	public static void main(String[] args) {
		
	    int answer = 0;
	    
	    String p = "82195";
	    String s = 	"64723";
	    
	    // 자리별로 비교하기 위해 문자열 반복탐색 시작
        for (int i=0; i<p.length(); i++) {
            
            int tmp = Character.getNumericValue(p.charAt(i));
	        int tmp2 = Character.getNumericValue(s.charAt(i));
            
            // p -> s 와 일치하기 위해 현재 순번이 몇번 회전을 해야하는지를 받아낼 변수
            int rotate = 0;
            
            // 현재순번끼리 단순계산(단 회전수가 음수가 될 수 있으므로 큰 수 - 작은 수 규칙 설정)
            // 단순계산이므로 최소회전인지 알 수 없음
            if (tmp > tmp2) {
                rotate = tmp - tmp2;    
            } else if(tmp < tmp2) {
                rotate = tmp2 - tmp;
            }
            
            // 회전수가 5를 초과한다면 최소회전이 아니므로 반대 회전수를 구한다.
            if (rotate > 5) {
                rotate = 10 - rotate;
            }
            
            // 최종 회전수 적립
            answer += rotate;
        }
        
	    System.out.println("answer : " + answer);
	     
		
	}

}
