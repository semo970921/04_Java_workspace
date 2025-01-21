package ex;

public class VariableEx4 {
    public static void main(String[] args) {

        final double PI = 3.141592;
        final int NATIONAL_CODE = 82;

        final int TEMP; // 상수에 처음이자 마지막으로 값 대입(초기화)
        TEMP = 100;
        //TEMP = 200; // 처음 초기화 이후 값 대입 불가(오류)

        System.out.println("[상수 확인]");

        int r = 5; // 반지름
        System.out.println("원의 둘레 : " + (2 * PI * r));
        System.out.println("원의 넓이 : " + (PI * r * r));

        System.out.println("국가 코드 : " + NATIONAL_CODE);
        System.out.println("TEMP : " + TEMP);

        // --------------------------------------------------------------

        System.out.println("오버 플로우(Overflow)");

        int num = Integer.MAX_VALUE;
        System.out.println("num : " + num); // num : 2147483647

        num = num + 1;
        System.out.println("num + 1 : " + num); // num + 1 : -2147483648

        num = num - 1;
        System.out.println("num +1 - 1 : " + num); // num +1 - 1 : 2147483647
    }
}
