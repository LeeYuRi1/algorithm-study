package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(s[j]);
                if (map.containsKey(k)) map.put(k, map.get(k) + 1);
                else map.put(k, 1);
            }
        }

        int resultTime = 999999999;
        int resultH = 0;
        int min = Collections.min(map.keySet());
        int max = Collections.max(map.keySet());
        for (int i = min; i <= max; i++) {
            int minus = 0;
            int plus = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (i < key) plus += value * (key - i);
                else if (i > key) minus += value * (i - key);
            }

            if (b + plus >= minus) {
                int time = plus * 2 + minus;
                if (resultTime >= time) {
                    resultTime = time;
                    resultH = i;
                }
            }
        }
        System.out.println(resultTime + " " + resultH);
    }
}
