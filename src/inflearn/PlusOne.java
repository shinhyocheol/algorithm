package inflearn;

public class PlusOne {

    public static void main(String[] args) {

        int[] digits = {1, 9, 9};
        int[] result = slove(digits);

        for(int res : result) {
            System.out.println(res);
        }

    }

    public static int[] slove(int[] digits) {
        int len = digits.length;

        for (int i=len-1; i>=0; i--) {

            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;

        return result;
    }

}
