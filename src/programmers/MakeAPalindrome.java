package programmers;

/**
 * 문제 설명
 * 팰린드롬이란 뒤에서부터 읽어도 원래와 똑같은 문자열을 의미합니다.
 *
 * 예를 들어, abab는 팰린드롬 문자열이 아닙니다. 하지만 뒤에 a를 추가한다면 ababa가 되어 앞에서부터 읽을 때와 뒤에서부터 읽을 때가 똑같은 팰린드롬 문자열이 되고, 이때 문자열의 길이는 5가 됩니다. 이처럼 문자열이 주어질 때, 문자열의 뒤에 적절히 문자를 추가한다면 팰린드롬인 문자열로 만들 수 있습니다.
 *
 * 문자열이 주어질 때, 문자열의 뒤에 최소한의 문자를 추가해 팰린드롬 문자열로 만든 후, 만들어진 팰린드롬 문자열의 전체 길이를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 문자열의 길이는 1,000 이하의 자연수입니다.
 * 문자열은 모두 소문자로만 이루어져 있습니다.
 * 입출력 예
 * plain	result
 * abab	5
 * abcde	9
 * 입출력 예 설명
 * 입출력 예 #1
 * 'abab'의 뒤에 'a'를 추가하면 'ababa'가 되어 팰린드롬인 문자열이 되고 길이는 5 입니다.
 *
 * 입출력 예 #2
 * 'abcde'의 뒤에 'dcba'를 추가하면 'abcdedcba'가 되어 팰린드롬인 문자열이 되고 길이는 9 입니다.
 */
public class MakeAPalindrome {

    public static void main(String[] args) {

        // 결과를 담아낼 변수
        int answer = 0;

        // 제시어
        String plain = "abab";

        // StringBuilder, StringBuffer 클래스는 reverse() 메소드를 제공하며, 해당 메소드를 통해 문자열을 거꾸로 뒤집을 수 있다.
        // 둘 중 어느것을 사용하여도 상관없음
        // 우선 제시어 자체가 펠린드롬이 성립되는지부터 확인
        if (plain.equals(new StringBuilder(plain).reverse().toString())) {
            answer = plain.length();
        }

        // 제시받은 문자열의 끝에 한글자씩 붙여보고, 펠린드롬 여부를 확인
        // 여기서 조건은 붙이는 글자를 뒤집어서 붙인다.
        for (int i=0; i<plain.length(); i++) {

            // StringBuilder의 append기능을 통해 뒤에 글자 붙이기
            StringBuilder palindrome = new StringBuilder(plain);
            palindrome.append(new StringBuilder(plain.substring(0, i)).reverse().toString());

            // 펠린드롬 여부 확인
            if (palindrome.toString().equals(palindrome.reverse().toString())) {
                answer = palindrome.length();
                System.out.println(answer);
            }

        }

    }

}
