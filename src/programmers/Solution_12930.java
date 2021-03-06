package programmers;

// 이상한 문자 만들기
public class Solution_12930 {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        String answer = "";
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                n = 0;
                answer += " ";
            } else {
                if (n % 2 == 0) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
                n++;
            }
        }
        return answer;
    }
}
