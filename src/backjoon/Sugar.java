package backjoon;

public class Sugar {

    public static void main(String[] args) {

        // 봉지단위 : 3, 5
        // 최대한 적은 봉지를 써서 배달해야함
        // 예를 들어 배달해야하는 설탕이 18 이라면 최소 봉지 수는 4(5: 3, 3: 1)
        Sugar a = new Sugar();

        System.out.println(a.getMinCount(18));
        System.out.println(a.getMinCount(4));
        System.out.println(a.getMinCount(6));
        System.out.println(a.getMinCount(9));
        System.out.println(a.getMinCount(11));

    }

    public int getMinCount(int sugarWeight) {

        int result = 0;
        int three = 3;
        int five = 5;

        while (sugarWeight > 0) {

            int fiveBagCount = sugarWeight % five;
            if (fiveBagCount == 0) {
                result += sugarWeight / 5;
                break;
            } else {
                sugarWeight = sugarWeight - three;
                if (sugarWeight < 0) {
                    result = -1;
                    break;
                }
                result++;
            }
        }


        return result;

    }

}
