package programmers;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrinterLocation {

    class Task{
        int priority;
        int location;

        public Task(int priority, int location) {
            this.priority = priority;
            this.location = location;

        }
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        PrinterLocation a = new PrinterLocation();

        int result = a.solution(priorities, location);
        System.out.println("result : " + result);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Task> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new Task(priorities[i], i));
        }
        int now = 0;
        while (!queue.isEmpty()) {
            Task cur = queue.poll();
            boolean flag = false;
            for (Task t : queue) {
                if (cur.priority < t.priority)
                    flag = true;
            }
            if (flag)
                queue.offer(cur);
            else {
                now++;
                if (cur.location == location)
                    answer = now;
            }
        }
        return answer;
    }
}
