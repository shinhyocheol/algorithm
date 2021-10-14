package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindSosu {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";
        FindSosu a = new FindSosu();

        int result = a.solution(numbers);

        System.out.println("Result : " + result);
    }
    public int solution(String numbers) {

        String[] strs = new String[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        for (int i=0; i<numbers.length(); i++) {
            strs[i] = Character.toString(numbers.charAt(i));
        }
        for (int i=0; i<strs.length; i++) {
            if (!visited[i]) dfs(strs, "", visited, i);
        }
        System.out.println(set.stream().collect(Collectors.toList()));
        return set.size();
    }

    public void dfs(String[] strs, String str, boolean[] visited, int idx) {

        visited[idx] = true;

        str += strs[idx];
        int num = Integer.parseInt(str);
        if (!isDecimal(num) && !set.contains(num)) set.add(num);

        for (int i=0; i<strs.length; i++) {
            if (!visited[i]) {
                dfs(strs, str, visited, i);
                visited[i] = false;
            }
        }
        visited[idx] = false;

    }

    public boolean isDecimal(int num) {
        boolean flag = false;
        if(num == 2 || num == 3) flag = false;

        if (num > 1) {
            for (int i = 2; i < (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = true;
                }
            }
        } else {
            flag = true;
        }
        return flag;
    }
}
