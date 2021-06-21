package codingPractice;

import java.util.Iterator;

public class ListRotation {
	
	public static int[] soultion(int[] A, int K) {
		
		// 리스트 복사
		int[] result = A.clone();
		// 리스트 길이
		int size = A.length;
		
		// 회전수만큼 반복시작
		for (int i=0; i<K; i++) {
			
			// 리스트 탐색시작
			for (int j=0; j<A.length; j++) {
				
				// 현재 옮겨야하는 요소의 순번이 마지막이라면 첫번째로 아니면 현재의 다음순서로 이동
				if (j+1 < size) {
					result[j+1] = A[j];
				} else {
					result[0] = A[j];
				}
			}
			// 작업이 끝난 후 다음 회전을 위해 리스트 업데이트
			A = result.clone();
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] A = {1, 2, 3, 4};
		int[] result = soultion(A, 3);
		
		for(int i = 0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
