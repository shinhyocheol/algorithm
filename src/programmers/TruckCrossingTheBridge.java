package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingTheBridge {

    public static void main(String[] args) {
        int bridge_length = 2;                  // 다리에 올라갈 수 있는 트럭 수
        int weight = 10;                        // 다리가 견딜 수 있는 최대 무게
        int[] truck_weights = {7,4,5,6};        // 대기중인 트럭들의 무게

        TruckCrossingTheBridge a = new TruckCrossingTheBridge();
        int result = a.solution(bridge_length, weight, truck_weights);

        System.out.println("result : " + result);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int result = 0;

        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> moving = new LinkedList<>();
        for (int val : truck_weights) {
            waiting.offer(val);
        }

        int cnt = 0;                    // 현재 올라탄 트럭 수
        while (!waiting.isEmpty()) {    // 대기중인 트럭이 없을때까지
            int truck_weight = waiting.poll();  // 우선 저장된 트럭 꺼내고
            cnt++;                              // 다리에 올라탄 트럭수 증가
            result++;                           // 시간 증가
            // 저장된 트럭이 존재하는지 확인
            if (!waiting.isEmpty()) {
                // 다음 트럭의 무게를 가져와서
                int prev = truck_weight;
                int next = waiting.peek();
                // 현재 다리에 올라간 트럭의 무게와 합쳤을때 다리가 버틸 수 있는 무게이하이고,
                // 다리에 트럭을 올릴 수 있는 최대치에 아직 미치지 않았다면
                while ((truck_weight + next) <= weight && cnt <= bridge_length) {
                    // 해당 트럭 꺼내서 다리에 올라간 트럭으로 무게 합치고, 현재 다리에 올라간 트럭수 증가
                    truck_weight += waiting.poll();
                    cnt++;
                    result++;
                }


            }

        }

        return result;
    }

}
