package programmers;

public class Carpet {

    public static void main(String[] args) {

        Carpet a = new Carpet();

        int brown = 10;
        int yellow = 2;

        int[] result = a.solution(brown, yellow);

        System.out.println("가로 : " + result[0]);
        System.out.println("세로 : " + result[1]);
    }

    public int[] solution(int brown, int yellow) {

        int[] result = new int[2];

        int area = brown + yellow;

        for (int w=3; w<=area; w++) {
            if (area % w == 0) {
                int h = area / w;
                if (((w-2)*(h-2)) == yellow && w >= h)
                    return new int[]{w, h};
            }
        }

        return result;
    }

}
