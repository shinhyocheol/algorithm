package codingPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 ** <문제 설명>
 * 3의 거듭 제곱수는 3을 b번 곱한 수를 의미하며 3b 형태로 표현합니다. 30 = 1이 성립하며, 31 = 3, 32 = 9, 33 = 27, 34 = 81... 모두 거듭 제곱수입니다.
 * 3의 거듭 제곱수를 임의로 더하여 거듭 제곱수 사이에 들어가는 수를 만들 수 있습니다. 예를 들어,

 * 4 = 1 + 3
 * 31 = 27 + 3 + 1
 * 입니다.
 * 이때, 같은 거듭 제곱수를 2번 이상 더할 수는 없습니다. 이러한 규칙으로 만들어낼 수 있는 수와 3의 거듭 제곱수를 합쳐서 순서대로 배치하면 1, 3, 4, 9, 10...이 됩니다. 
 * 이렇게 배치한 숫자의 n번째 숫자가 무엇인지를 알려주는 함수 solution 을 완성해주세요.

 ** <제한사항>
 * n은 1 ≤ n ≤ 1010 인 자연수
 * 
 * 
 ** <입출력 예 설명>
 * 
 * 입출력 예 #1
 * 1, 3, 4, 9... 로 4번째 숫자는 9입니다.
 * 입출력 예 #2
 * 1, 3, 4, 9, 10, 12, 13, 27, 28, 30, 31 ... 로 11번째 숫자는 31입니다.
 */
public class BetweenSquares {

	public static void main(String[] args) {
		
		long answer = 0;
		
		long n = 40;
		int a = 3;
		
		
		List<Long> squares = new ArrayList<Long>(); // 제곱수 리스트
		List<Long> betweenSquares = new ArrayList<Long>(); // 제곱수 및 사이 수 합산 리스트
		List<Long> sums = new ArrayList<Long>(); // 순번 별로 존재하는 합이 수를 저장할 리스트
		
		squares.add((long) 1); // 30 = 1이 성립되므로 첫번째 요소는 1로 지정
		betweenSquares.add((long) 1); // 마찬가지
		
		// 우선 제곱수 리스트 생성(리스트 사이즈는 기준이 따로 없으므로 n을 활용)
		for (int i=0; i<n; i++) {
			long tmp = (a * squares.get(i));
			
			squares.add(tmp);
			betweenSquares.add(tmp);
		}
		
		for (int i=1; i<squares.size(); i++) {
			
			if (i == 1) 
			{
				// 첫번째인 경우 합이 가능한 경우는 한가지
				long tmp = (squares.get(i - 1) + squares.get(i));
				betweenSquares.add((long) tmp);
			} 
			else if (i > 1 && i < squares.size() - 1) 
			{
				// 그 외의 경우 제곱근의 합이 가능한 경우는 순서에 따라 다름
				// 기본적으로 나올 수 있는 경우 우선 계산
				long tmp = (squares.get(i-1) + squares.get(i));
				betweenSquares.add(tmp);
				
				long sum = 0; // 이전 요소를 누적계산할때마다 받아낼 변수
				for (int j=0; j<i; j++) // 그 외의 합의 경우를 계산하기 위해 i번째를 기준으로 이전 요소의 합을 내부반복문을 통해 계산
				{
					// 중복요소 검사
					if (!betweenSquares.contains(squares.get(j) + squares.get(i))) 
						betweenSquares.add(squares.get(j) + squares.get(i));
					
					// 조합 저장소도 중복을 검사하며 현재의 조합을 저장
					if (!sums.contains(squares.get(j) + squares.get(i)) && !betweenSquares.contains(squares.get(j) + squares.get(i))) 
						sums.add(squares.get(j) + squares.get(i)); 
					
					sum += squares.get(j); // 누적 합계변수
				}
				sums.add(sum); // 우선 저장
				sum = 0; // 요소 간 합계 누적 변수 초기화
				
				// 저장해둔 경우의 수 리스트를 가지고 한번 더 리스트 탐색하며 요소 사이에 들어갈 수가 있는지 확인
				for (int k=0; k<sums.size(); k++) {
					// 중복요소 검사
					if (!betweenSquares.contains(squares.get(i) + sums.get(k)))
						 betweenSquares.add(squares.get(i) + sums.get(k));
				}
			}
						
		}
		
		
		betweenSquares.sort(null); // 정렬
		sums.sort(null); // 정렬
		
		answer = betweenSquares.get((int) n - 1);
		System.out.println(answer);
		System.out.println(squares.get(squares.size()-1));
		
	}
	
}
