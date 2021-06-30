package dataStructure;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Queue : FIFO(First In First Out) 구조의 자료구조
 * @설명 : 컴퓨터의 기본적인 자료 구조의 한가지로, 먼저 집어 넣은 데이터가 먼저 나오는 자료구조이다.
 * 			- 영어단어 queue는 표를 사러 일렬로 늘어선 사람들로 이러우진 줄을 말하기도 하며, 
 * 			  먼저 줄을 선 사람이 먼저 나갈 수 있는 상황을 연상하면 된다.
 * 			- 나중에 집어 넣은 데이터가 먼저 나오는 스택과는 반대되는 개념이다.
 * 			- 프린터의 출력처리나 윈도 시스템의 메시지 처리기, 프로세스 관리 등 데이터가 입력 된
 * 			  시간 순서대로 처리해야 할 필요가 있는 상황에 이용된다.
 */
public class QueueEx {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
	
}
