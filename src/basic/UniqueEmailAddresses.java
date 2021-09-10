package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * @문제 : 고유한 이메일
 * @설명: 모든 유효한 이메일은 @을 기준으로 로컬이름과 도메인이름으로 구성됩니다.
 * 또한 소문자외에 하나 이상의 '.'또는 '+' 포함합니다.
 * 예) test@conding.com
 * test는 로컬이름이고 codingtest.com은 도메인 이름입니다.
 *
 * 코딩테스트 풀이
 * 1. 문제분석
 *  - 문제를 정확히 이해해야한다.
 *  - 분석 내용을 정리한다.
 *
 * 2. 규칙찾기
 *  - 분석 내용으로 규칙을 찾는다.
 *
 * 3. 코딩화
 *  - 분석 내용으로 알맞은 구현방법 찾기
 *
 * 4. 알고리즘 적용
 *  - 알고리즘을 정하고 담을 그릇을 정한다.(사전지식이 필요함)
 *
 *
 * 이메일에는 소문자 외의 '.'또는 '+'가 포함될 수 있습니다. 단 이 규칙은 로컬이름에만 적용되고, 도메인 이름에는 적용되지 않습니다.)
 * @1. 로컬이름에 일부 문자 사이에 마침표('.')를 추가하여 전송된 메일은 로컬이름에 점이 없는 동일한 주소로 전달됩니다.
 *    ## 예시) test.email@codingtest.com "및 "testemail@codingtest.com"은 동일한 이메일 주소로 전달됩니다.
 * @2. 로컬 이름에 더하기('+')를 추가하면 첫 번쨰 더하기 기호 뒤의 모든 항목이 무시됩니다. 이를 통해 특정 이메일을 필터링 할 수 있습니다.
 *    ## 예시) test.email+james@condingtest.com은 test.email@codingtest.com으로 메일이 전송됩니다.
 *
 *    문제 분석
 *      - 로컬네임 + 도메인 네임
 *      - 로컬네임에서는 .을 무시한다.
 *      - 로컬네임에서 + 이후로 나오는 문자열은 무시한다.
 *      - 도메인네임에서 .이 들어가면 고유하다.
 *
 *    규칙찾기
 *      - . => continue로 뺀다.
 *      - + => break로 뺀다.
 *      Set<String>을 활용해 중복을 제거하는 방식을 적용해본다.
 *
 *      시간복잡도
 *          대상 : 문제에서 입력받은 파라미터
 *          time complexity: O(N)
 *          대상 : String[] emails
 *          이유 : for문 한번 실행
 *
 *      공간복잡도
 *          space complexity: O(N)
 *          대상 : Set<String> set = new HashSet();
 *          이유 : for문 한번 실행
 *
 */
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses a = new UniqueEmailAddresses();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@cod.ing.com",
                "testemail+tom@cod.ing.com"
        };

        System.out.println("========================================");
        System.out.println(a.solve_1(emails));
        System.out.println(a.solve_split(emails));
        System.out.println("========================================");

    }

    // 3. split
    public int solve_split(String[] emails) {
        // "test.email+james@coding.com"
        // 1 ds
        Set<String> set = new HashSet<>();

        //2 for, while
        for (String email: emails) {
            String[] parts = email.split("@");
            // + 로만 패턴을 지정할 시 컴파일 에러가 발생한다. 따라서 아래처럼 괄호로 감싸거나 \\을 붙여줘야 제대로 인식한다.
            String[] localName = parts[0].split("[+]");
            System.out.println(localName[0].replace(".", "") + "@" + parts[1]);
            set.add(localName[0].replace(".", "") + "@" + parts[1]);
        }

        return set.size();
    }

    // 1
    public int solve_1(String[] emails) {
        //1 ds
        // 중복을 제외하고 고유한것만 담게 될 Set
        Set<String> set = new HashSet<>(); // 중복X

        //2 for while charAt()
        for(String email: emails) {

            String localName = makeLocalName(email);
            String dName = makeDName(email);

            System.out.println(localName + "@" + dName);

            set.add(localName + "@" + dName);
        }
        return set.size();

    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<email.length(); i++) {

            if(email.charAt(i)  == '.') {
                continue;
            }
            if(email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }

    private String makeDName(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

}
