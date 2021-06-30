package dataStructure;

import java.util.Stack;

/**
 *	@Statck : LIFO(Last In First Out) 구조의 자료구조 
 *	@설명 : 제한적으로 접근할 수 있는 나열구조이다. 접근 방법은 언제나 목록의 끝에서만 일어난다
 *			- 끝먼저내기목록(Pushdown list)라고도 불린다.
 *			- 스택은 한 쪽 끝에서만 자료를 넣거나 뺄 수 있는 선형구조로 되어있다.
 *			- 자료를 밀어넣는다고 하여 푸쉬(push)라고 하
 *			  반대로 넣어둔 자료를 꺼내는 것을 팝(pop)이라고 하는데, 이때 꺼내지는 자료는 
 *			  가장 최근에 푸쉬한 자료부터 나오게 된다. 이처럼 나중에 넣은 값이 먼저 나오는 것을
 *			  LIFO 구조라고 표현한다.
 *			- 인터넷 서핑 시 사용하는 뒤로가기 버튼이 스택으로 구현되었으며, 팬케이크 구조를 생각하면 된다.
 */
public class StackEx {
	
	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<Integer>();
		
		// 1부터 3까지 순서대로 푸쉬
		st.push(1);
		st.push(2);
		st.push(3);
		
		while (!st.isEmpty()) {
			
			// 가장 최근에 푸쉬된 요소부터 출력
			System.out.println(st.pop());
		}
		
	}

}
