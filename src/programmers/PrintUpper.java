package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class PrintUpper {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (Stream<String> stream = br.lines().map(s -> s.toUpperCase()).filter(s -> s.length() >= 5 && s.length() < 10) ) {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
