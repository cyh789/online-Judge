package programers.floor1.algo_20230523;

public class Main_12901 {

    public static void main(String[] args) {
        System.out.println(solution(1, 1));
        System.out.println(solution(5, 24));
    }

    private static String solution(int a, int b) {
        String answer = "";

        // 1. a월의 값을 담은 int 배열 months. 1월~12월이므로 size 12
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2. 날짜를 나타내는 값을 담은 String 배열 week. 일주일이므로 size 7
        // 2-1. 1월 1일은 금요일
        String[] week = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

        // 3. a(월)를 일수 day로 계산. int
        int day = 0;
        for (int i = 0; i < a-1; i++) {
            day += months[i];
        }

        // 4. day + b(일) % 7 하도록 cal로 계산. int
        // 4-1. 이렇게 할 경우 배열의 첫 값이 1/7(7의 배수)과 같게 됨.
        // 따라서 week[0] = "FRI" -> "THU" 변경하거나, 계산 할 때 고려할 것(b -> b-1).
        int cal = (day + (b - 1)) % 7;

        // 5. 배열 week에서 cal번째 요일을 answer에 담아서 응답
        answer = week[cal];

        return answer;
    }
}
