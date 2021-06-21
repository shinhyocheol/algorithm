package codingPractice;

public class BinaryGap {

	
	public static int solution(int N) {
		
		// 결과
		int result = 0;
		
		// 정수 이진변환
        String binary = Integer.toBinaryString(N);
        
        // 마지막이 0이라면 수행 X
        if (binary.charAt(binary.length() - 1) != '0') {
        	
	        // "1"를 분기점으로 리스트 생성
	        String[] list = binary.split("1");
	        
	        // 
	        for (int i=0; i<list.length; i++) {
	        	if(list[i].length() > result) {
	        		result = list[i].length();
	        	}
	        	
	        }
	        
        }
        
        System.out.println(result);
        return result;
    }
	
	public static void main(String[] args) {
		
		int result = solution(1041);
				
	}
}
