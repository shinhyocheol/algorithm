package programmers;

public class Supo {

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int supo1Grade = 0;
        int supo2Grade = 0;
        int supo3Grade = 0;

        int cnt = 0;

        for (int i=0; i<answers.length; i++) {

            int idx1 = i;
            int idx2 = i;
            int idx3 = i;

            if (idx1 > supo1.length - 1) {
                idx1 = (idx1) % supo1.length - 1;
            }
            if (idx2 > supo2.length - 1) {
                idx2 = (idx2) % supo2.length - 1;
            }
            if (idx3 > supo1.length - 1) {
                idx3 = (idx3) % supo1.length - 1;
            }

            if (answers[i] == supo1[idx1]) supo1Grade++;
            if (answers[i] == supo2[idx2]) supo2Grade++;
            if (answers[i] == supo3[idx3]) supo3Grade++;

        }

        int first = Math.max(Math.max(supo1Grade, supo2Grade), Math.max(supo2Grade, supo3Grade));

        if (first == supo1Grade) cnt++;
        if (first == supo2Grade) cnt++;
        if (first == supo3Grade) cnt++;

        answer = new int[cnt];

        if (first == supo1Grade) answer[0] = 1;
        if (first == supo2Grade) answer[1] = 2;
        if (first == supo3Grade) answer[2] = 3;

        return answer;
    }
}
