package codingPractice;

public class RecursionFun {

    public static void main(String[] args) {

        RecursionFun recurtion = new RecursionFun();

        // 해당 방식으로 배열을 생성하는 경우 함수에 매개변수로 넘겨 값을 변경하면 주소를 참조해 arr 자체의 값을 변경한다.
        // 따라서 배열의 값들이 공유가 되었다기보다는 포인트를 참조하기에 지역변수라고 하더라도 arr 자체가 바뀌었다고 볼 수 있다.
        int[] arr = new int[3];

        // 일반 정수형 변수는 주소가 아닌 값을 참조하기때문에 당연히 함수로 넘겨 값을 바꿔도 그에 대한 값을 돌려받지 않는 한 바뀌지 않는다.
        int num = 0;

        for (int i=0; i<arr.length; i++) {
            System.out.println("arr : " + arr[i]);
            System.out.println("num : " + num);
            if (arr[i] == 0) {
                recurtion.recursion(arr, i, num);
            }
        }
    }

    public void recursion(int[] arr, int i, int num) {
        arr[i] = 1;
        num++;
        for (int j=0; j<arr.length; j++) {
            if (arr[j] == 0) {
                recursion(arr, j, num);
            }
        }
    }

}
