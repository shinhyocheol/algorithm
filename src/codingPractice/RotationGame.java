package codingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RotationGame {

    public  static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);

        List<Integer> rotate = new ArrayList<>();
        rotate.add(0);
        rotate.add(9);

        List<Integer> result = new ArrayList<Integer>();

        for (int i=0; i<rotate.size(); i++) {

            int rotateCnt = rotate.get(i);          // 몇번 회전하는지 확인

            int max = Collections.max(a);           // 회전 리스트에서 가장 큰 수
            int maxPos = a.indexOf(max);            // 가장 큰 수의 현재 위치

            if (rotateCnt >= a.size()) {            // 회전 수를 리스트 길이만큼 나눈 후 나머지 만큼만 회전수 변경
                rotateCnt = rotateCnt % a.size();   // 이유는 회전 수가 리스트 길이보다 큰 경우, 예를 들어 리스트 길이는 4인데 회전수가 5라면 1번 회전한 것과 5번 회전한 것의 결과는 같기때문이다.
            }

            result.add(i, maxPos);                  // 회전하기전에 가장 큰 값의 인덱스 위치 우선 확보(왜냐면 한번도 회전하지 않을 수 있음)

            for (int j=0; j<rotateCnt; j++) {       // 회전시작
                for (int k=0; k<a.size(); k++) {    // 회전시작
                    int pos = 0;                    // 이동할 위치를 받아낼 변수
                    if (k + 1 < a.size()) {         // 현재 순번이 마지막 순서가 아니라면 다음 순번으로 이동 포지션을 변경해준다. 마지막 순번이면 첫번째로 이동하기때문에 0 그대로 유지
                        pos = k + 1;                // 이동 포지션 확정
                    }
                    if (max <= a.get(k)) {          // 현재수가 가장 큰수보다 크다면
                        max = a.get(k);             // 가장 큰 수 변경
                        result.set(i, pos);         // 회전 전에 저장해두었던 큰 값의 인덱스 위치 변경
                    }
                }
            }
        }

        Collections.sort(result);                   // 내림차순으로 정렬하기 위해 우선 오름차순 정렬(reverse()는 sort()가 선행된 후 사용해야 제대로 작동함)
        Collections.reverse(result);                // 내림차순으로 변경

        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
