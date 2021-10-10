package codility;

import java.util.HashSet;

public class OddOccurrencesInArray {

    public static void main(String[] args) {

        OddOccurrencesInArray a = new OddOccurrencesInArray();
        int[] arr = {9, 3, 9, 3, 9, 7, 9};
        int result = a.solution(arr);

        System.out.println("result : " + result);

    }

    public int solution(int[] arr) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            if (set.contains(arr[i])) {
                System.out.println(i + " : " +arr[i]);
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        for (int integer : set) {
            result = integer;
        }
        return result;
    }

}
