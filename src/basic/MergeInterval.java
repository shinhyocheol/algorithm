package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @문제설명 : intervals 배열이 주어지면 겹치는 구간을 병합한 후 해당 배열을 반환 합니다.
 * @풀이설명 : 예를들어 [1,4], [2,6], [8,10], [15,18] 요소를 가진 배열이 주어지면
 *          [1,4], [2,6] 은 겹치는 구간이 됩니다. 이 설명을 가지고 각 겹치는 구간을 병합하면
 *          [1,6], [8,10], [15,18] 이라는 배열이 되고, 반환됩니다.
 * @문제분석 : 겹치는 부분을 합친다.
 *          [1,4]에서 4와 [2,6]에서 2를 비교해서 합친다.
 *          [1,6]을 결과리스트에 저장한다.
 *
 * @시간복잡도 : O(NlogN)
 *  대상 : intervals -> int[][]
 *  이유 : sorting logN, N개의 요소들이 for문 한번 실행
 *
 * @공간복잡도 : O(N) or O(logN)
 *  대상 : List<int[]> res = new ArrayList<>();
 *  이유 : int[][] intervals 자체를 이용하면 O(1)이지만, res를 만들어서 저장하면 O(N),
 *          갯수가 줄어들면 O(logN)이 된다.
 */
public class MergeInterval {

    public static void main(String[] args) {

        MergeInterval a = new MergeInterval();

        int[][] intervals = {{1,4}, {2,6}, {8,10}, {15,18}};
        int[][] result = a.slove(intervals);

        for (int i=0; i<result.length; i++) {
            System.out.println("i : " + i);
            for (int j=0; j<result[i].length; j++) {
                System.out.print("i["+j+"] : " + result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int[][] slove(int[][] intevals) {
        List<int[]> res = new ArrayList<>();
        if (intevals.length == 0 || intevals == null)
            return res.toArray(new int[0][]);

        // 1. sort
        Arrays.sort(intevals, (a, b) -> a[0] - b[0]); // 오름차순

        // 2. for
        int start = intevals[0][0];
        int end = intevals[0][1];
        // start 1, end 4
        for (int i=1; i<intevals.length; i++) {
//            System.out.println("i :" + i);
            if (end >= intevals[i][0]) {
                end = Math.max(end, intevals[i][1]);
                // 2,6 -> 1,6
            } else {
                res.add(new int[] {start, end});
                start = intevals[i][0];
                end = intevals[i][1];
            }
        }
        // 마지막 순번은 담기지 않았으므로 for문을 나와서 현재의 start, end를 담아준다.
        res.add(new int[] {start, end});

        return res.toArray(new int[res.size()][]);
    }
}
