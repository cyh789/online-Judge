package programers_floor_1_202305;

public class Main_12901 {

    public static void main(String[] args) throws Exception {
        int a = 1;
        int b = 13;

        String answer = "";
        int[] monthArr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayArr = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };

        int day = b;
        for (int i = 0; i < a-1; i++) {
            day += monthArr[i];
        }

        answer = dayArr[day % 7];
    }
}
