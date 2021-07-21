package codingPractice;

import java.util.PriorityQueue;


/**
 * @문제 : 프로그래머스 코딩테스트 문제 : 더 맵게
 * @설명 : 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶다.
 * 			모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두개의 음식을 
 * 			아래와 같이 특별한 방법으로 섞어 새로운 음식을 만드려고 한다.
 * 
 * @방법 : 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * 
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어 질때, 모든 음식의
 * 스코빌 지수를 K이상으로 만들기 위해 섞어야 하는 최소 횟수를 구한다.
 *
 * @참고 : 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */
public class MakeHotFood {

	public static void main(String[] args) {
		
		int scoville[] = {1, 2, 3, 9, 10, 12}; // 기존 음식들의 스코빌 지수
		int K = 7; // 스코빌 지수 기준
		
		int answer = 0; // 반환 카운트 변수
		boolean chk = false; // 새로운 음식 제조가능여부
		
		// PriorityQueue : 우선순위 큐
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		// scoville을 우선순위 큐에 담는다. 이때 우선순위 큐 클래스는 순서를 낮은 순서로 재정렬한다.
		for (int i=0; i<scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while (queue.size() > 1 && queue.peek() < K) {
            
            int firstMin = queue.poll(); 				// 스코빌 지수가 가장 낮은 음식
            int secondMin = queue.poll(); 				// 스코빌 지수가 두번째로 낮은 음식
            queue.add(firstMin + (secondMin * 2)); 		// leo 만의 방법으로 제조
            
            answer++;									// 섞었으니 횟수 추가
            
            // 한번이라도 카운트 된다면 새로운 음식을 제조할 수 있다는 뜻이니 제조여부 flag를 true로 전환한다.
            if (queue.peek().intValue() >= K) {			
                chk = true;
            }
        }
        
        // 반복문을 도는동안 제조여부 flag가 바뀌지 않았다면 제조가 불가능하다는 뜻이므로 결과는 -1
        if (!chk) {
            answer = -1;
        }


		System.out.print(answer);
	}

}
